
package com.orlov_prokhor.wayonmap.presentation.internal.di.components;

import android.content.Context;
import com.orlov_prokhor.wayonmap.domain.repository.PathPointsRepository;
import com.orlov_prokhor.wayonmap.presentation.internal.di.modules.ApplicationModule;
import com.orlov_prokhor.wayonmap.presentation.view.activity.BaseActivity;
import dagger.Component;
import javax.inject.Singleton;


@Singleton // Constraints this component to one-per-application or unscoped bindings.
@Component(modules = ApplicationModule.class)
public interface ApplicationComponent {

  void inject(BaseActivity baseActivity);

  //Exposed to sub-graphs.
  Context context();


  PathPointsRepository PathPointRepository();
}
