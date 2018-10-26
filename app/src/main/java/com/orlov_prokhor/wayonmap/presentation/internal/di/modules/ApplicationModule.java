
package com.orlov_prokhor.wayonmap.presentation.internal.di.modules;

import android.content.Context;
import com.orlov_prokhor.wayonmap.data.repository.PathPointDataRepository;
import com.orlov_prokhor.wayonmap.domain.repository.PathPointsRepository;
import com.orlov_prokhor.wayonmap.presentation.AndroidApplication;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;

/**
 * Dagger module that provides objects which will live during the application lifecycle.
 */
@Module
public class ApplicationModule {

  private final AndroidApplication application;

  public ApplicationModule(AndroidApplication application) {
    this.application = application;
  }

  @Provides
  public Context getContext() {
    return application;
  }


  @Provides
  @Singleton
  public PathPointsRepository provideUserRepository(PathPointDataRepository pathPointsRepository) {
    return pathPointsRepository;
  }
}
