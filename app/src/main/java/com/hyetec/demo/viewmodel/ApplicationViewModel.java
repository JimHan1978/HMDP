package com.hyetec.demo.viewmodel;

import android.app.Application;

import com.hyetec.demo.model.ApplicationModel;
import com.hyetec.hmdp.core.mvvm.BaseViewModel;

public class ApplicationViewModel extends BaseViewModel<ApplicationModel> {
    public ApplicationViewModel(Application application, ApplicationModel model) {
        super(application, model);
    }
}
