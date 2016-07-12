package com.doulala.android.base.di;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

import javax.inject.Qualifier;

/**
 * Created by doulala on 16/7/12.
 */


@Qualifier
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface ActivityContextQualifier {

    
}