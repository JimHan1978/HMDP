package com.hyetec.demo.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;

import com.hyetec.demo.R;
import com.hyetec.demo.app.EventBusTags;
import com.hyetec.demo.viewmodel.MainViewModel;
import com.hyetec.hmdp.core.base.BaseActivity;

public class MainActivity extends BaseActivity<MainViewModel> {

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.container, MainFragment.newInstance())
                    .commitNow();
        }
    }*/

    @Override
    public int initView(Bundle savedInstanceState) {
        //创建ViewModel
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        if (savedInstanceState != null) {
            //Restore data
            //mReplace = savedInstanceState.getInt(EventBusTags.ACTIVITY_FRAGMENT_REPLACE);
        }
        return R.layout.main_activity;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        mViewModel.getLocation().observe(this, s ->
                getSupportActionBar().setTitle(s));
    }
}
