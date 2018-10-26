
package com.orlov_prokhor.wayonmap.presentation;

import android.app.Application;
import com.orlov_prokhor.wayonmap.presentation.internal.di.components.ApplicationComponent;
import com.orlov_prokhor.wayonmap.presentation.internal.di.components.DaggerApplicationComponent;
import com.orlov_prokhor.wayonmap.presentation.internal.di.modules.ApplicationModule;
import com.squareup.leakcanary.LeakCanary;


/**
 * Android Main Application
 */
public class AndroidApplication extends Application {

  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();
    this.initializeInjector();
    this.initializeLeakDetection();
  }

  private void initializeInjector() {
    this.applicationComponent = DaggerApplicationComponent.builder()
                                                          .applicationModule(
                                                              new ApplicationModule(this))
                                                          .build();
  }
  public ApplicationComponent getApplicationComponent() {
    return this.applicationComponent;
  }

  private void initializeLeakDetection() {
    if (LeakCanary.isInAnalyzerProcess(this)) {
      // This process is dedicated to LeakCanary for heap analysis.
      // You should not init your app in this process.
      return;
    }
    LeakCanary.install(this);
  }
}
