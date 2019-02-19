package com.hyetec.demo.viewmodel;

import android.app.Application;

import com.hyetec.demo.model.ContactsModel;
import com.hyetec.hmdp.core.mvvm.BaseViewModel;

public class ContactsViewModel extends BaseViewModel<ContactsModel> {
    public ContactsViewModel(Application application, ContactsModel model) {
        super(application, model);
    }
}
