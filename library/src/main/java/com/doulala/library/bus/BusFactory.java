package com.doulala.library.bus;

import android.app.Activity;
import android.util.Log;

import com.hwangjr.rxbus.RxBus;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.util.ArrayList;

/**
 * Created by doulala on 16/7/8.
 * 用来管理Bus类的生命周期
 *
 */
class BusFactory {

    private final ArrayList<Object> objects_bus_for_oncreate = new ArrayList<>();

    private final ArrayList<Object> objects_bus_for_resume = new ArrayList<>();

    Object object;

    public BusFactory(RxbusActivity activity) {
        this.object = activity;
    }

    public BusFactory(RxbusFragment fragment) {
        this.object = fragment;
    }

    protected void init() {

        collectBusAnnotation(object.getClass());
    }


    void collectBusAnnotation(Class clazz){

        if(clazz.getName().equals(RxbusActivity.class.getName()) ||clazz.getName().equals(RxbusFragment.class.getName()))
            return;

        Field[] fields= clazz.getDeclaredFields();
        for (Field f : fields) {
            collectBusAnnotationObject(f);
        }
        collectBusAnnotation(clazz.getSuperclass());
    }





    /**
     * @param f 遍历的Field
     *          <p/>
     *          对@Bus标记的对象进行手机,
     */
    private void collectBusAnnotationObject(Field f) {
        if (f.isAnnotationPresent(Bus.class)) {
            try {

                f.setAccessible(true);
                Object obj = f.get(object);

                if (obj == null) {
                    throw new RuntimeException("@Bus Filed could not be null!");
                }
                if (isSimpleType(obj)) {

                    throw new RuntimeException("@Bus Filed could not annotation simple type");
                }
                Bus annotation = f.getAnnotation(Bus.class);
                if (annotation.life() == LifeCycle.onCreate) {

                    objects_bus_for_oncreate.add(obj);
                }
                if (annotation.life() == LifeCycle.onResume) {

                    objects_bus_for_resume.add(obj);
                }

            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        }
    }


    /**
     * 判断对象是否后是简单对象.
     *
     * @param obj
     * @return
     */
    private boolean isSimpleType(Object obj) {

        if (obj instanceof String)
            return true;
        if (obj instanceof Number)
            return true;

        if (obj instanceof Boolean)
            return true;
        if (obj instanceof Character)
            return true;

        if (obj.getClass().isArray())
            return true;


        return false;
    }


    protected void onCreate() {
        RxBus.get().register(object);
        for (Object obj : objects_bus_for_oncreate) {
            RxBus.get().register(obj);
        }
    }

    protected void onDestory() {

        for (Object obj : objects_bus_for_resume) {
            RxBus.get().unregister(obj);
        }
        RxBus.get().unregister(object);
    }

    protected void onResume() {
        for (Object obj : objects_bus_for_resume) {
            RxBus.get().register(obj);
        }

    }

    protected void onPause() {
        for (Object obj : objects_bus_for_resume) {
            RxBus.get().unregister(obj);
        }
    }


}
