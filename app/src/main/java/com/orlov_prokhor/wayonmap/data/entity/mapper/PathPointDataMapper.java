
package com.orlov_prokhor.wayonmap.data.entity.mapper;

import com.orlov_prokhor.wayonmap.data.entity.PathPointEntity;
import com.orlov_prokhor.wayonmap.domain.PathPoint;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class PathPointDataMapper {

  @Inject
  PathPointDataMapper() {}


  public PathPoint transform(PathPointEntity pathPointEntity) {
    PathPoint pathPoint = null;
    if (pathPointEntity != null) {
      pathPoint = new PathPoint();
      pathPoint.setLatitude(pathPointEntity.getLatitude());
      pathPoint.setLongitude(pathPointEntity.getLongitude());
    }
    return pathPoint;
  }


  public List<PathPoint> transform(Collection<PathPointEntity> userEntityCollection) {
    final List<PathPoint> pathPointList = new ArrayList<>(20);
    for (PathPointEntity userEntity : userEntityCollection) {
      final PathPoint pathPoint = transform(userEntity);
      if (pathPoint != null) {
        pathPointList.add(pathPoint);
      }
    }
    return pathPointList;
  }
}
