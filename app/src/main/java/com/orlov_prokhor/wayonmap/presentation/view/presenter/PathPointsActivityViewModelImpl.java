package com.orlov_prokhor.wayonmap.presentation.view.presenter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
import android.util.Log;
import android.widget.Toast;
import com.orlov_prokhor.wayonmap.domain.PathPoint;
import com.orlov_prokhor.wayonmap.domain.repository.PathPointsRepository;
import com.orlov_prokhor.wayonmap.presentation.AndroidApplication;
import java.util.List;
import javax.inject.Inject;

public class PathPointsActivityViewModelImpl extends AndroidViewModel implements
                                                                      PathPointsActivityViewModel {

  @Inject
  public  PathPointsRepository             pointsRepository;
  private ObservableField<List<PathPoint>> pathPointList = new ObservableField<>();

  public PathPointsActivityViewModelImpl(
      @NonNull Application application) {
    super(application);
    ((AndroidApplication) application).getApplicationComponent().inject(this);

    Log.i("delete log  ", pointsRepository.toString());
  }

  @Override
  public ObservableField<List<PathPoint>> getPathPointList() {
    return pathPointList;
  }

  @Override
  public void showPath() {
    Toast.makeText(this.getApplication(), "showPath", Toast.LENGTH_LONG).show();
    pointsRepository.pathPoints().subscribe(
        list -> {
          Log.i("list: ", "" + list.size());
          pathPointList.set(list);
        }
        , err -> {
          /*try {
            Log.i("list err: ", err.getMessage());
          } catch (Exception e) {
            Log.i("list err222: ", e.getMessage());
          }*/
        });
  }
}
