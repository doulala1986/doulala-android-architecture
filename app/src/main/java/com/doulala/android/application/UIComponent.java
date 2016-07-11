package com.doulala.android.application;

import com.doulala.library.manager.image.ImageCacheMananger;

import dagger.Subcomponent;

/**
 * Created by doulala on 16/7/11.
 *
 * 参见AppComponent
 */

@Subcomponent
public interface UIComponent {

    ImageCacheMananger imageCacheMananger();
}
