package com.doulala.library.manager.storage;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import rx.Observable;
import rx.Subscriber;
import  rx.Observable.Transformer;
import rx.schedulers.Schedulers;

/**
 * Created by doulala on 16/7/5.
 * <p/>
 * 存储简单数据的Manager,实质上是对SharedPreference的封装,支持Rxable.
 * 注意由于SP的操作是对内存的操作,所以在选择Scheduler的时候要选择Schedulers.computation();
 */
public class ValueStorageManager {


    private SharedPreferences preferences;


    public ValueStorageManager(Context context, String name) {

        if (TextUtils.isEmpty(name)) {
            preferences = PreferenceManager.getDefaultSharedPreferences(context.getApplicationContext());
        } else {
            preferences = context.getSharedPreferences(name, Context.MODE_PRIVATE);
        }
    }
    public ValueStorageManager(Context context) {

       this(context,null);
    }

    //region schedulers transformers
    private  final Observable.Transformer schedulersTransformer = new Observable.Transformer(){

        @Override
        public Object call(Object observable) {
            return ((Observable)observable).subscribeOn(Schedulers.computation());
        }
    };

    private  <T> Transformer<T, T> applySchedulers() {
        return (Transformer<T, T>) schedulersTransformer;
    }
    //endregion

    //region String getter/setter
    public void set(String key, String value) {
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(key, value);
        editor.commit();
    }

    public String get(String key, String defaultValue) {

        return preferences.getString(key, defaultValue);

    }

    public Observable<Boolean> rxset(final String key,final String value) {
        return Observable.create(new Observable.OnSubscribe<Boolean>() {
            @Override
            public void call(Subscriber<? super Boolean> subscriber) {
                set(key,value);
                subscriber.onNext(true);
                subscriber.onCompleted();
            }
        }).compose(this.<Boolean>applySchedulers());
    }

    public Observable<String> rxget(final String key,final String defaultValue) {
        return Observable.create(new Observable.OnSubscribe<String>() {
            @Override
            public void call(Subscriber<? super String> subscriber) {
                String value=  get(key,defaultValue);
                subscriber.onNext(value);
                subscriber.onCompleted();
            }
        }).compose(this.<String>applySchedulers());
    }
    //endregion

}
