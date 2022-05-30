package com.example.androidsoa.di;

import com.example.androidsoa.Principal.PrincipalView;
import com.example.androidsoa.Signup.SignupView;

import dagger.Module;
import dagger.Provides;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBuilderModule {
    @ContributesAndroidInjector
    abstract SignupView contributeSignupView();

    @ContributesAndroidInjector
    abstract PrincipalView contributePrincipalView();
}
