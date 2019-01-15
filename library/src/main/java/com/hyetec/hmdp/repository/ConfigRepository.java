package com.hyetec.hmdp.repository;

import android.content.Context;

import com.hyetec.hmdp.repository.di.module.RepositoryConfigModule;

/**
 * @author xiaobailong24
 * @date 2017/9/28
 * Repository 配置接口
 */
public interface ConfigRepository {
    /**
     * 使用 {@link RepositoryConfigModule.Builder} 给框架配置一些配置参数
     *
     * @param context Context
     * @param builder GlobalConfigModule.Builder
     */
    void applyOptions(Context context, RepositoryConfigModule.Builder builder);

}
