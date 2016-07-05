package com.doulala.android.base.ui;

import com.doulala.library.view.toast.IToastManager;
import javax.inject.Inject;

/**
 * Created by doulala on 16/7/5.
 */
public class Activity_UI_Base extends Activity_Base {


    //region Add ToastManager
    @Inject
    protected IToastManager toastManager;

    public IToastManager toastManager() {
        return toastManager;
    }
    //endregion



}
