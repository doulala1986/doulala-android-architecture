package com.doulala.android.model.account;

import org.parceler.Parcel;

/**
 * Created by doulala on 16/7/7.
 *
 * 业务模块类,主要用来设置核心功能模块.
 *
 * 关于@Parcel可以参考: www.Parceler.org
 */
@Parcel
public class Module {


    protected String uri;

    protected String name;

    protected int status;

    public Module() {


    }

    public String getUri() {
        return uri;
    }

    public String getName() {
        return name;
    }

    public void setUri(String uri) {
        this.uri = uri;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }
}
