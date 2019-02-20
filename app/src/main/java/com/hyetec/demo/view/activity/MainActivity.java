package com.hyetec.demo.view.activity;

import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.EditText;

import com.hyetec.demo.R;
import com.hyetec.demo.app.EventBusTags;
import com.hyetec.demo.view.adapter.MainPagerAdapter;
import com.hyetec.demo.view.fragment.ApplicationFragment;
import com.hyetec.demo.view.fragment.ContactsFragment;
import com.hyetec.demo.view.fragment.MessageFragment;
import com.hyetec.demo.view.fragment.PersonalFragment;
import com.hyetec.demo.viewmodel.MainViewModel;
import com.hyetec.hmdp.core.base.BaseActivity;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

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

    private int mReplace = 0;
    private List<Fragment> mFragments;
    private List<String> mFragmentTitles;
    private int IconImg [] = {
            R.mipmap.tab_message_normal,
            R.mipmap.tab_address_book_normal,
            R.mipmap.tab_app_normal,
            R.mipmap.tab_setting_normal
    };

    @BindView(R.id.tab_layout)
    TabLayout tabLayout;

    @BindView(R.id.content_pager)
    ViewPager contentViewPager;

    @Override
    public int initView(Bundle savedInstanceState) {

        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);
        //创建ViewModel
        mViewModel = ViewModelProviders.of(this, mViewModelFactory).get(MainViewModel.class);
        if (savedInstanceState != null) {
            //Restore data
            mReplace = savedInstanceState.getInt(EventBusTags.ACTIVITY_FRAGMENT_REPLACE);
        }
        return R.layout.main_activity;
    }

    @Override
    public void initData(Bundle savedInstanceState) {
        initViewPager();
    }

    private void initViewPager() {
        if (mFragments == null) {
            mFragments = new ArrayList<>();
        }
        if (mFragmentTitles == null) {
            mFragmentTitles = new ArrayList<>();
        }

        MessageFragment messageFragment = (MessageFragment) getSupportFragmentManager()
                .findFragmentByTag("MessageFragment");
        ContactsFragment contactsFragment = (ContactsFragment) getSupportFragmentManager()
                .findFragmentByTag("ContactsFragment");
        ApplicationFragment applicationFragment = (ApplicationFragment) getSupportFragmentManager()
                .findFragmentByTag("ApplicationFragment");

        PersonalFragment personalFragment = (PersonalFragment) getSupportFragmentManager()
                .findFragmentByTag("PersonalFragment");
        if (messageFragment == null) {
            messageFragment = MessageFragment.newInstance();
        }
        if (contactsFragment == null) {
            contactsFragment = ContactsFragment.newInstance();
        }

        if (applicationFragment == null) {
            applicationFragment = ApplicationFragment.newInstance();
        }
        if (personalFragment == null) {
            personalFragment = PersonalFragment.newInstance();
        }

        mFragments.add(messageFragment);
        mFragments.add(contactsFragment);
        mFragments.add(applicationFragment);
        mFragments.add(personalFragment);
        mFragmentTitles.add("消息");
        mFragmentTitles.add("通讯录");
        mFragmentTitles.add("应用");
        mFragmentTitles.add("我的");

        //Setup ViewPager
        MainPagerAdapter pagerAdapter =
                new MainPagerAdapter(getSupportFragmentManager(), mFragments, mFragmentTitles);
        contentViewPager.setAdapter(pagerAdapter);
        tabLayout.setupWithViewPager(contentViewPager);
        contentViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                Timber.i("onPageSelected: %s", position);
                mReplace = position;
            }

            @Override
            public void onPageScrollStateChanged(int state) {
            }
        });
    }
}
