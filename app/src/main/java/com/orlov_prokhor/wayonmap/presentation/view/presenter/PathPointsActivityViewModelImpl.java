package com.orlov_prokhor.wayonmap.presentation.view.presenter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.orlov_prokhor.wayonmap.domain.repository.PathPointsRepository;
import com.orlov_prokhor.wayonmap.presentation.AndroidApplication;
import javax.inject.Inject;

public class PathPointsActivityViewModelImpl extends AndroidViewModel implements
                                                                      PathPointsActivityViewModel {

  @Inject
  public PathPointsRepository pointsRepository;



  public PathPointsActivityViewModelImpl(
      @NonNull Application application) {
    super(application);
    ((AndroidApplication) application).getApplicationComponent().inject(this);

    Log.i("delete log  ", pointsRepository.toString());
  }

  @Override
  public void showPath() {
    Toast.makeText(this.getApplication(), "showPath", Toast.LENGTH_SHORT).show();
    pointsRepository.pathPoints().subscribe(
        list -> {
          Log.i("list: ", "" + list.size());
        }
        , err -> {
          Log.i("list err: ", err.getMessage());
        });
  }
}
