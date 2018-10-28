package com.orlov_prokhor.wayonmap.presentation.view.presenter;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.databinding.ObservableField;
import android.support.annotation.NonNull;
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


  }

  @Override
  public ObservableField<List<PathPoint>> getPathPointList() {
    return pathPointList;
  }

  @Override
  public void showPath() {

    pointsRepository.pathPoints().subscribe(
        list -> {

          pathPointList.set(list);
        }
        , err -> {

        });
  }
}
