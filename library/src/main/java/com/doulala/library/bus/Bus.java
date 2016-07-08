package com.doulala.library.bus;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created by doulala on 16/7/8.
 *
 * 使用方式 @Bus,通过这个标签可以自动的在Activity Fragment 对应的周期自动进行注册 和反注册
 *
 */


@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface Bus {

    /**
     *
     * 设置该对象注册的时机,默认是onCreate.
     *
     * onCreate-onDestory onResume-onPause
     *
     * @return
     */
    LifeCycle life() default LifeCycle.onCreate;

}
