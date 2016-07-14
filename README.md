# 基于Rxjava+Dagger2+Rxbus的MVP模式开发框架


## 架构图

依赖注入架构：

![](http://doulala.oss-cn-qingdao.aliyuncs.com/di.jpg)

**说明：**

1.所有的注入链从下向上看是线性的，但是允许有多条注入链。

2.框架一共包括了两组注入链，分别对应的是UI组件注入以及数据组件注入。

3.**AppComponent** 主要用来暴露通用的组件，比如ApplicationContext、全局设置信息、状态信息等。

4.**UIComponent** 作为AppComponent的一个subComponent，主要用向下层@Scope暴露UI相关的组件，比如ImageCacheManager、MapManager等。

5.**DataComponent** 作为AppComponent的另一个subComponent，主要用来向下层提供数据访问的组件，比如Retrofit、DatabaseManager、ValueStoreageManager等。

6.**BaseUIActivityComponent** 一方面是用来完成对BaseActivity的注入，同时负责一些属于Activity生命周期的对象的维护与传递，例如：ToastManager、DialogManager等。

7.**SubActivityComponents** 用来统一管理所有具体的Activity对应的SubComponent。普通的Activity通过@SubComponent的方式对Base进行扩展，我们认为SubActivityComponents属于业务层面，所以他被放置在： **com.doulala.android.biz.injector** 包中。

8.**DataManagerModuel** 用来对所有DataManager进行了统一注入与管理，同样属于**com.doulala.android.biz.injector** 包。

9.**BaseFragmentComponent** 主要用来获取Activity以及Application注入的对象，比如Activity创建的ToastManager、DialogManager

10.**SubFragmentComponents**用处与SubActivityComponent相似。

---

MVP架构：
![](http://doulala.oss-cn-qingdao.aliyuncs.com/mvp3.jpg)

**说明：**

1.**View 层需要实现IViewContract,只负责向外发出UI事件**，并处理UI上对状态、数据变化的响应，这一层是可以轻松被替换掉的。

2.**DataManager层主要是对资源的操作的封装。**这里的资源包括你定义的业务实体、手机状态、甚至经纬度。在这里我们认为所有的数据都是资源，所有的处理都是对资源的操作。在这里可以集成你的网络框架、持久化存储框架等。

3.**Rxjava在DataManager中的使用**。我们在DataManager中会把所有资源操作封装成Rxjava中的Observable，粒度可以尽可能的细致，这些将组成我们可以用到的所有子逻辑单元。全部使用Observable的好处在于我们的子逻辑单元形式统一，互相之间可以轻松组合使用，代码风格也趋于一致。

4.**Presenter层主要用来进行业务组合与订阅。**在Presenter中我们把DataManager中的子逻辑进行组合，形成复杂的业务逻辑，同时进行Subscribe,Presenter通过维护IViewContract实例的方式从抽象层面与View建立通信、回调。这么设计可以完全做到和View层的解耦，一方面方便对View层的更新，更重要的是如果需要进行单元测试，直接拿Presenter进行测试即可。

5**.Bus层被设计成另一种Presenter，他主要用来处理全局状态初始化与变更操作**。如用户帐号、权限、主题等状态，这些状态的改变通常来自DataManager对资源的操作。

## 一步一坑

### Dagger

1.Dagger更适合注入那些那些地址不会变更的实例，如果注入的实例可能发生变化，切仍然希望使用Dagger完成注入，如UserAccount，那么需要使用@Provider或者@Lazy通过get\(\)动态获取，注意：**千万不要用@Singleton或者@Scope修饰注入的变量**。

2.在Google的mvp的例子中，使用了@Inject注释了一个方法，这个作用是在注入过程中，类的实例创建后，会立刻执行这些方法。

---

### 事件总线：

**父类与子类间切换**

1.我们一开始使用了RXbus，主要是因为rxbus提供了@Produce注释用来进行组件的状态初始化，用起来很nice。但是我们发现，当我在Activity\_UI\_Base种定义的@Subscribe，在他的子类Activtiy\_Login加载时变得无效了，可能是因为所有的标签只是扫描注册的那个子类内部的@Subscribe，不会扫描他的父类。暂时放弃。

2.转战eventbus，rxbus只是底层使用了rxjava实现，在使用时并不能和rxandroid联动，所以就无关痛痒了，于是我们选择使用老牌eventbus，但是不支持@Produce，所以放弃。

3.试试otto,线程切换又她妈很难过。

和Rxbus的作者沟通后发现自己对java的熟练掌握程度不够，并不是框架的原因。

[解决方案](https://github.com/AndroidKnife/RxBus/issues/13)：

```
 private Object rxbusAccount = new Object() {//中间对象
 @Subscribe(tags = {@Tag(Account.RXBUS_TAG_ACCOUNT_UPDATED)})
        public void accountUpdated(Account newAccount) {
            onFindAccountUpdated(newAccount);
        }
    };

 protected void onFindAccountUpdated(Account newAccount) {
        this.account=newAccount;
}
```

---

## 设计思路

1.什么时候用Dagger？

> 首先，我觉得Dagger比较适合对**引用不变**的对象进行注入，对于可变对象，如token、account等对象更加适合用rxbus进行处理。如果需要对状态变更进行响应，也更适合用rxbus。

2.Dagger对于Component层级关系的处理。

> 在设计过程中，由于@Scope的依赖链是单向的，所以我们在处理具体业务的component时需要在@Activty的scope下再添加一个@Scope，感觉就会怪怪的，这时候比较适合使用SubComponent来处理具体业务的注入问题。同时考虑到可维护性和可移植性，让baseActivityComponent不那么臃肿，我们使用了一个接口来管理所有的SubComponent

3.Presenter的注入方式

> 在参考Google的 [dagger-mvp](https://github.com/googlesamples/android-architecture/tree/todo-mvp-dagger/) 时，我发现他们选择了在Activity中完成注入，所有的view则都是一个个fragment\(即使只有一个界面\)。Activity在中间起到了注入管理的作用。google3分钟给出答案 [issus](https://github.com/googlesamples/android-architecture/issues/116)，具体来说，他们认为fragment是一个可复用、轻量且模块化的组件。仔细想想，也确实是这样。

3.组件中如何使用rxbus快速的响应状态，而不需要关心rxbus间的协议。

> 我在设计中，用单独的类对rxbus的协议进行了封装，统一通过callback interface 的方式完成回调，然后对该类的实例进行了rxbus注册，这样做即能够屏蔽rxbus的协议，又能解决parent与child之间的注册逻辑问题。另外，为了减少上层开发人员对注册和反注册的处理，我添加了@Bus注解来处理注册问题，创建了RxbusActivity，RxbusFragment两个基本组件类。
