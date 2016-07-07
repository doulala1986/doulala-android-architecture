package com.doulala.android.model.user;

import android.content.Context;

import com.doulala.android.application.DApplication;
import com.hwangjr.rxbus.RxBus;

import org.parceler.Parcel;

import java.util.ArrayList;

/**
 * Created by doulala on 16/7/5.
 * <p/>
 * 用户账户信息类.
 * <p/>
 * 关于@Parcel可以参考: www.Parceler.org
 */

@Parcel
public class Account {

    public static final String RXBUS_TAG_ACCOUNT_UPDATED = "RXBUS_TAG_ACCOUNT_UPDATED";

    public static final Account NULL = new Account();//设置一个对象代表未登录状态


    protected String userId;

    protected String name;

    protected String token;

    protected long time_login;

    protected ArrayList<String> permissions;

    protected ArrayList<Module> modules;

    public Account() {

    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<String> getPermissions() {
        return permissions;
    }

    public void setPermissions(ArrayList<String> permissions) {
        this.permissions = permissions;
    }

    public ArrayList<Module> getModules() {
        return modules;
    }

    public void setModules(ArrayList<Module> modules) {
        this.modules = modules;
    }

    public long getTime_login() {
        return time_login;
    }

    public void setTime_login(long time_login) {
        this.time_login = time_login;
    }


    /**
     * @param context 更新App登录账户信息
     */
    public void update(Context context) {
        DApplication.get(context).AccountUpdate(this);
    }

    public static void clear(Context context) {
        Account.NULL.update(context);
    }

    public static boolean isNull(Account account) {
        return account == null || account == Account.NULL;

    }
}
