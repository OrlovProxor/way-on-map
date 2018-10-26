package com.orlov_prokhor.wayonmap.data.repository;

import com.orlov_prokhor.wayonmap.data.entity.mapper.PathPointDataMapper;
import com.orlov_prokhor.wayonmap.data.repository.datasource.PathPointDataStore;
import com.orlov_prokhor.wayonmap.data.repository.datasource.PathPointDataStoreFactory;
import com.orlov_prokhor.wayonmap.domain.PathPoint;
import com.orlov_prokhor.wayonmap.domain.repository.PathPointsRepository;
import io.reactivex.Observable;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;

@Singleton
public class PathPointDataRepository implements PathPointsRepository {

  private final PathPointDataStoreFactory pathPointDataStoreFactory;
  private final PathPointDataMapper       pathPointDataMapper;

  @Inject
  public PathPointDataRepository(
      PathPointDataStoreFactory pathPointDataStoreFactory,
      PathPointDataMapper pathPointDataMapper) {
    this.pathPointDataStoreFactory = pathPointDataStoreFactory;
    this.pathPointDataMapper = pathPointDataMapper;
  }

  @Override
  public Observable<List<PathPoint>> pathPoints() {
    //we always get all users from the cloud
    final PathPointDataStore userDataStore = this.pathPointDataStoreFactory.createCloudDataStore();
    return userDataStore.pathPointList().map(this.pathPointDataMapper::transform);

  }
}
