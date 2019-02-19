package com.hyetec.demo.viewmodel;

import android.app.Application;

import com.hyetec.demo.model.PersonalModel;
import com.hyetec.hmdp.core.mvvm.BaseViewModel;

public class PersonalViewModel extends BaseViewModel<PersonalModel>{
    public PersonalViewModel(Application application, PersonalModel model) {
        super(application, model);
    }
}
