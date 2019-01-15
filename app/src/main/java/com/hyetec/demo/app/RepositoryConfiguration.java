package com.hyetec.demo.app;

import android.content.Context;

import com.hyetec.demo.BuildConfig;
import com.hyetec.demo.model.api.Api;
import com.hyetec.hmdp.repository.ConfigRepository;
import com.hyetec.hmdp.repository.cache.Cache;
import com.hyetec.hmdp.repository.cache.LruCache;
import com.hyetec.hmdp.repository.di.module.RepositoryConfigModule;
import com.hyetec.hmdp.repository.http.RequestInterceptor;

import java.util.concurrent.TimeUnit;



/**
 * @author xiaobailong24
 * @date 2017/9/28
 * Repository 的全局配置信息在此配置,需要将此实现类声明到 AndroidManifest 中
 */
public class RepositoryConfiguration implements ConfigRepository {
    @Override
    public void applyOptions(Context context, RepositoryConfigModule.Builder builder) {
        //Release 时,让框架不再打印 Http 请求和响应的信息
        if (!BuildConfig.LOG_DEBUG) {
            builder.printHttpLogLevel(RequestInterceptor.Level.NONE);
        }

        builder.baseUrl(Api.APP_DOMAIN)
                // 这里提供一个全局处理 Http 请求和响应结果的处理类,可以比客户端提前一步拿到服务器返回的结果
                .globalHttpHandler(new GlobalHttpHandlerImpl())
                // 用来处理 rxjava 中发生的所有错误,rxjava 中发生的每个错误都会回调此接口
                // rxjava 必要要使用 ErrorHandleSubscriber (默认实现Subscriber的onError方法),此监听才生效
                .responseErrorListener(new ResponseErrorListenerImpl())
                //这里可以自己自定义配置Gson的参数
                .gsonConfiguration((context1, gsonBuilder) -> {
                    gsonBuilder
                            .serializeNulls()//支持序列化null的参数
                            .enableComplexMapKeySerialization();//支持将序列化key为object的map,默认只能序列化key为string的map
                })
                //这里可以自己自定义配置Retrofit的参数,甚至你可以替换系统配置好的okhttp对象
                .retrofitConfiguration((context1, retrofitBuilder) -> {
                     /*比如使用fastjson替代gson
                     retrofitBuilder.addConverterFactory(FastJsonConverterFactory.create());*/
                    /*适配 LiveData
                    retrofitBuilder.addCallAdapterFactory(new LiveDataCallAdapterFactory());*/
                })
                //这里可以自己自定义配置Okhttp的参数
                .okhttpConfiguration((context1, okhttpBuilder) -> {
                    //支持 Https
                    //okhttpBuilder.sslSocketFactory()
                    okhttpBuilder.writeTimeout(10, TimeUnit.SECONDS);
                })
                //这里可以自己自定义配置 RxCache 的参数
                .rxCacheConfiguration((context1, rxCacheBuilder) -> {
                    rxCacheBuilder.useExpiredDataIfLoaderNotAvailable(true);
                    return null;
                })
                //这里可以自定义配置 RoomDatabase，比如数据库迁移升级
                .roomConfiguration((context1, roomBuilder) -> {
/*                    roomBuilder.addMigrations(new Migration(2, 3) {
                        @Override
                        public void migrate(SupportSQLiteDatabase database) {
                            // TODO: 2017/9/22
                            // Since we didn't alter the table, there's nothing else to do here.
                        }
                    });*/
                })
                //可根据当前项目的情况以及环境为框架某些部件提供自定义的缓存策略,具有强大的扩展性
                .cacheFactory(type -> {
                    switch (type) {
                        case EXTRAS_CACHE_TYPE:
                            //外部 extras 默认最多只能缓存500个内容
                            return new LruCache(500);
                        /*case CUSTOM_CACHE_TYPE:
                            return new CustomCache();//自定义 Cache*/
                        default:
                            //RepositoryManager 中的容器默认缓存 100 个内容
                            return new LruCache(Cache.Factory.DEFAULT_CACHE_SIZE);
                    }
                });
    }

}
