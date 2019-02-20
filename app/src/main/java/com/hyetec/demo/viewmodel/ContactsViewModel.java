package com.hyetec.demo.viewmodel;

import android.app.Application;

import com.hyetec.demo.model.ContactsModel;
import com.hyetec.hmdp.core.di.scope.FragmentScope;
import com.hyetec.hmdp.core.mvvm.BaseViewModel;

import javax.inject.Inject;

@FragmentScope
public class ContactsViewModel extends BaseViewModel<ContactsModel> {
    @Inject
    public ContactsViewModel(Application application, ContactsModel model) {
        super(application, model);
    }
}
