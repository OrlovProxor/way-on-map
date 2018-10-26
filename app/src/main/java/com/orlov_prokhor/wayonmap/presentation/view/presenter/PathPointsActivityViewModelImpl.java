package com.orlov_prokhor.wayonmap.presentation.view.presenter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.widget.Toast;

public class PathPointsActivityViewModelImpl extends AndroidViewModel implements
                                                                      PathPointsActivityViewModel {

  public PathPointsActivityViewModelImpl(
      @NonNull Application application) {
    super(application);
  }

  @Override
  public void showPath() {
    Toast.makeText(this.getApplication(), "showPath", Toast.LENGTH_LONG).show();
  }
}
