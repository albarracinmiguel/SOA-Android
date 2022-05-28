package com.example.androidsoa.di;

import android.app.Application;

import com.example.androidsoa.data.MyDatabase;
import com.example.androidsoa.network.SOAService.SOAApi;
import com.example.androidsoa.util.Constants;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApplicationModule {
    @Singleton
    @Provides
    static MyDatabase provideDatabaseInstance(Application application) {
        return new MyDatabase(application.getApplicationContext());
    }

    @Singleton
    @Provides
    static Retrofit provideRetrofitInstance(){
        return new Retrofit.Builder().baseUrl(Constants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }
    @Singleton
    @Provides
    static SOAApi provideSoaService(Retrofit retrofit){
        return retrofit.create(SOAApi.class);
    }
}
