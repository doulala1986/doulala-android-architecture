package com.doulala.android.application;

import com.doulala.library.manager.storage.ValueStorageManager;

import dagger.Subcomponent;

/**
 * Created by doulala on 16/7/11.
 *
 * 参见AppComponent
 */

@Subcomponent
public interface DataComponent {


    ValueStorageManager valueStorageManager();

}
