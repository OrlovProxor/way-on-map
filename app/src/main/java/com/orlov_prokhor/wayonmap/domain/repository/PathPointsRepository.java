package com.orlov_prokhor.wayonmap.domain.repository;


import com.orlov_prokhor.wayonmap.domain.PathPoint;
import io.reactivex.Observable;
import java.util.List;

public interface PathPointsRepository {

  Observable<List<PathPoint>> pathPoints();
}
