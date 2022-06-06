package com.example.androidsoa.di;

import android.app.Application;
import android.content.Context;

import com.example.androidsoa.BaseApplication;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;
@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        ActivityBuilderModule.class,
        ApplicationModule.class,
})
public interface IAppComponent extends AndroidInjector<BaseApplication> {
    @Component.Builder
    interface Builder{
        @BindsInstance
        Builder application(Application application);
        IAppComponent build();
    }
}
