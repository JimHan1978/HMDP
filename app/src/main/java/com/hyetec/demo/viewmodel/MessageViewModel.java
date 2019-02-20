package com.hyetec.demo.viewmodel;

import android.app.Application;

import com.hyetec.demo.model.MessageModel;
import com.hyetec.hmdp.core.di.scope.FragmentScope;
import com.hyetec.hmdp.core.mvvm.BaseViewModel;

import javax.inject.Inject;

@FragmentScope
public class MessageViewModel extends BaseViewModel<MessageModel> {
    @Inject
    public MessageViewModel(Application application, MessageModel model) {
        super(application, model);
    }
}
