package com.orlov_prokhor.wayonmap.presentation.view.presenter;

import android.databinding.ObservableField;
import com.orlov_prokhor.wayonmap.domain.PathPoint;
import java.util.List;

public interface PathPointsActivityViewModel {

  public ObservableField<List<PathPoint>> getPathPointList();
  public void showPath();
}
