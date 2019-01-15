package com.hyetec.hmdp.core.base;

import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.ViewModelProvider;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.hyetec.hmdp.core.mvvm.BaseViewModel;
import com.hyetec.hmdp.core.mvvm.IViewModel;
import com.hyetec.hmdp.lifecycle.delegate.IActivity;

import javax.inject.Inject;

/**
 * @author xiaobailong24
 * @date 2017/6/16
 * MVVM BaseActivity
 * 如果只使用 DataBinding, 则 VM 的泛型可以传 {@link BaseViewModel}
 */
public abstract class BaseActivity<VM extends IViewModel>
        extends AppCompatActivity implements IActivity {
    protected final String TAG = this.getClass().getName();

    /**
     * ViewDataBinding
     */
    //protected DB mBinding;

    /**
     * MVVM ViewModel ViewModelProvider.Factory
     */
    @Inject
    protected ViewModelProvider.Factory mViewModelFactory;
    /**
     * instance in subclass; 自动销毁
     */
    protected VM mViewModel;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initView(savedInstanceState);
        //设置DataBinding
        //mBinding = DataBindingUtil.setContentView(this, );
        initData(savedInstanceState);
        if (mViewModel != null) {
            getLifecycle().addObserver((LifecycleObserver) mViewModel);
        }
    }

    @Override
    public boolean useEventBus() {
        return true;
    }


    @Override
    public boolean useFragment() {
        return true;
    }

    @Override
    public boolean injectable() {
        return true;
    }

    @SuppressWarnings("all")
    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        /**
         * 新姿势：通过ViewModel保存数据。
         *  @see <a href="https://developer.android.com/topic/libraries/architecture/viewmodel.html#viewmodel_vs_savedinstancestate">ViewModel vs SavedInstanceState</a>
         */
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        //this.mBinding = null;
        this.mViewModelFactory = null;
        //移除LifecycleObserver
        if (mViewModel != null) {
            getLifecycle().removeObserver((LifecycleObserver) mViewModel);
        }
        this.mViewModel = null;
    }
}