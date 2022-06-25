package com.example.androidsoa.di;

import com.example.androidsoa.Principal.PrincipalView;
import dagger.Binds;
import dagger.Module;
import dagger.Subcomponent;
import dagger.android.AndroidInjector;
import dagger.multibindings.ClassKey;
import dagger.multibindings.IntoMap;

@Module(
  subcomponents = ActivityBuilderModule_ContributePrincipalView.PrincipalViewSubcomponent.class
)
public abstract class ActivityBuilderModule_ContributePrincipalView {
  private ActivityBuilderModule_ContributePrincipalView() {}

  @Binds
  @IntoMap
  @ClassKey(PrincipalView.class)
  abstract AndroidInjector.Factory<?> bindAndroidInjectorFactory(
      PrincipalViewSubcomponent.Factory builder);

  @Subcomponent
  public interface PrincipalViewSubcomponent extends AndroidInjector<PrincipalView> {
    @Subcomponent.Factory
    interface Factory extends AndroidInjector.Factory<PrincipalView> {}
  }
}
