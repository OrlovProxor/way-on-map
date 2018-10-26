package com.orlov_prokhor.wayonmap.data.net;

import com.orlov_prokhor.wayonmap.data.entity.PathPointEntity;
import io.reactivex.Observable;
import java.util.List;

/**
 * RestApi for retrieving data from the network.
 */
public interface RestApi {

  String API_PATH_POINTS_URL =
      "https://test.www.estaxi.ru/route.txt";


  Observable<List<PathPointEntity>> pathPointList();


}
