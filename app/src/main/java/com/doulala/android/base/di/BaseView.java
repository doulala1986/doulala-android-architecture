/*
 * Copyright 2016, The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.doulala.android.base.di;


/**
 * 参考了一下https://github.com/googlesamples/android-architecture
 * <p/>
 * 在这个项目中,每个Activity都会对应一个Fragment,View是Fragment,注入是通过Activity完成,
 * Presenter在Activity中创建,通过在注入时自动运行此方法,把presenter传递给Fragment
 *
 *
 */
@Deprecated
public interface BaseView<T> {

    void setPresenter(T presenter);

}
