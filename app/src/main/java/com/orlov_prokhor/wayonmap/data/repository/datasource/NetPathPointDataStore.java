package com.orlov_prokhor.wayonmap.data.repository.datasource;

import com.orlov_prokhor.wayonmap.data.entity.PathPointEntity;
import com.orlov_prokhor.wayonmap.data.net.RestApi;
import io.reactivex.Observable;
import java.util.List;

public class NetPathPointDataStore implements PathPointDataStore {

  private RestApi restApi;

  public NetPathPointDataStore(RestApi restApi) {this.restApi = restApi;}

  @Override
  public Observable<List<PathPointEntity>> pathPointList() {
 /*   return Observable.just("").subscribeOn(Schedulers.io()).map((it)->{
      return it;
    });*/
    return null;
  }


}
