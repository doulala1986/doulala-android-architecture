package com.doulala.android.model.user;

import android.content.Context;

import com.doulala.android.application.DApplication;

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

    protected String userId;

    protected String name;

    protected String token;

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

    /**
     * @param context
     *
     *
     *
     */
    public void update(Context context) {

        DApplication.get(context).setAccount(this);

    }


}
