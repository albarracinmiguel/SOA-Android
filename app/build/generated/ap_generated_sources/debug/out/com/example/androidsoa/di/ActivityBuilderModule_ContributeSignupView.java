package com.example.androidsoa.di;

import com.example.androidsoa.Signup.SignupView;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(subcomponents = ActivityBuilderModule_ContributeSignupView.SignupViewSubcomponent.class)
public abstract class ActivityBuilderModule_ContributeSignupView {
  private ActivityBuilderModule_ContributeSignupView() {}

  @Binds
  @IntoMap
  @ClassKey(SignupView.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      SignupViewSubcomponent.Factory builder);

  @Subcomponent
  public interface SignupViewSubcomponent extends AndroidInjector<SignupView> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<SignupView> {}
  }
}
