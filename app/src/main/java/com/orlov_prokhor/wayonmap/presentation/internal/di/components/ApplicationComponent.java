
package com.orlov_prokhor.wayonmap.presentation.internal.di.components;

import android.content.Context;
import com.orlov_prokhor.wayonmap.domain.repository.PathPointsRepository;
import com.orlov_prokhor.wayonmap.presentation.internal.di.modules.ApplicationModule;
import com.orlov_prokhor.wayonmap.presentation.view.activity.BaseActivity;
import com.orlov_prokhor.wayonmap.presentation.view.presenter.PathPointsActivityViewModelImpl;
import dagger.Component;
import javax.inject.Singleton;


@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  public void inject(BaseActivity baseActivity);

  public void inject(PathPointsActivityViewModelImpl baseViewModel);

  //Exposed to sub-graphs.
  public Context context();


  public PathPointsRepository pathPointRepository();
}
