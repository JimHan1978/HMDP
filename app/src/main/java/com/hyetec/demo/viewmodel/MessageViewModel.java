package com.hyetec.demo.viewmodel;

import android.app.Application;

import com.hyetec.demo.model.MessageModel;
import com.hyetec.hmdp.core.mvvm.BaseViewModel;

public class MessageViewModel extends BaseViewModel<MessageModel> {
    public MessageViewModel(Application application, MessageModel model) {
        super(application, model);
    }
}
