package com.example.androidsoa.di;

import com.example.androidsoa.Login.LoginView;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityBuilderModule_ContributeLoginView.LoginViewSubcomponent.class)
public abstract class ActivityBuilderModule_ContributeLoginView {
  private ActivityBuilderModule_ContributeLoginView() {}

  @Binds
  @IntoMap
  @ClassKey(LoginView.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      LoginViewSubcomponent.Factory builder);

  @Subcomponent
  public interface LoginViewSubcomponent extends AndroidInjector<LoginView> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<LoginView> {}
  }
}
