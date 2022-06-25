// Generated by Dagger (https://dagger.dev).
package com.example.androidsoa.Login;

import com.example.androidsoa.data.MyDatabase;
import com.example.androidsoa.network.SOAService.SOAApi;
import dagger.MembersInjector;
import dagger.android.DispatchingAndroidInjector;
import dagger.android.support.DaggerAppCompatActivity_MembersInjector;
import dagger.internal.DaggerGenerated;
import dagger.internal.InjectedFieldSignature;
import dagger.internal.QualifierMetadata;
import javax.inject.Provider;

@QualifierMetadata
@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class LoginView_MembersInjector implements MembersInjector<LoginView> {
  private final Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider;

  private final Provider<SOAApi> soaApiProvider;

  private final Provider<MyDatabase> databaseProvider;

  public LoginView_MembersInjector(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<SOAApi> soaApiProvider, Provider<MyDatabase> databaseProvider) {
    this.androidInjectorProvider = androidInjectorProvider;
    this.soaApiProvider = soaApiProvider;
    this.databaseProvider = databaseProvider;
  }

  public static MembersInjector<LoginView> create(
      Provider<DispatchingAndroidInjector<Object>> androidInjectorProvider,
      Provider<SOAApi> soaApiProvider, Provider<MyDatabase> databaseProvider) {
    return new LoginView_MembersInjector(androidInjectorProvider, soaApiProvider, databaseProvider);
  }

  @Override
  public void injectMembers(LoginView instance) {
    DaggerAppCompatActivity_MembersInjector.injectAndroidInjector(instance, androidInjectorProvider.get());
    injectSoaApi(instance, soaApiProvider.get());
    injectDatabase(instance, databaseProvider.get());
  }

  @InjectedFieldSignature("com.example.androidsoa.Login.LoginView.soaApi")
  public static void injectSoaApi(LoginView instance, SOAApi soaApi) {
    instance.soaApi = soaApi;
  }

  @InjectedFieldSignature("com.example.androidsoa.Login.LoginView.database")
  public static void injectDatabase(LoginView instance, MyDatabase database) {
    instance.database = database;
  }
}
