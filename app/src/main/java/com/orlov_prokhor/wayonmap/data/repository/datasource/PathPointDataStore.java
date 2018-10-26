package com.orlov_prokhor.wayonmap.data.repository.datasource;


import com.orlov_prokhor.wayonmap.data.entity.PathPointEntity;
import io.reactivex.Observable;
import java.util.List;

/**
 * Interface that represents a data store from where data is retrieved.
 */
public interface PathPointDataStore {

  Observable<List<PathPointEntity>> pathPointList();

}
