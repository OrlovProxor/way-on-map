package com.orlov_prokhor.wayonmap.data.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.orlov_prokhor.wayonmap.data.entity.PathPointEntity;
import com.orlov_prokhor.wayonmap.data.entity.mapper.PathPointJsonMapper;
import com.orlov_prokhor.wayonmap.data.exception.NetworkConnectionException;
import io.reactivex.Observable;
import java.net.MalformedURLException;
import java.util.List;

/**
 * {@link RestApi} implementation for retrieving data from the network.
 */
public class RestApiImpl implements RestApi {

  private final Context             context;
  private final PathPointJsonMapper pathPointJsonMapper;

  public RestApiImpl(Context context,
                     PathPointJsonMapper pathPointJsonMapper) {
    this.context = context;
    this.pathPointJsonMapper = pathPointJsonMapper;
  }


  @Override
  public Observable<List<PathPointEntity>> pathPointList() {
    return Observable.create(emitter -> {
      if (isThereInternetConnection()) {
        try {
          String responseUserEntities = getUserEntitiesFromApi();
          if (responseUserEntities != null) {
            emitter.onNext(pathPointJsonMapper.transformPathPointCollection(
                responseUserEntities));
            emitter.onComplete();
          } else {
            emitter.onError(new NetworkConnectionException());
          }
        } catch (Exception e) {
          emitter.onError(new NetworkConnectionException(e.getCause()));
        }
      } else {
        emitter.onError(new NetworkConnectionException());
      }
    });
  }

  private String getUserEntitiesFromApi() throws MalformedURLException {
    return ApiConnection.createGET(API_PATH_POINTS_URL).requestSyncCall();
  }

  private boolean isThereInternetConnection() {
    boolean isConnected;

    ConnectivityManager connectivityManager =
        (ConnectivityManager) this.context.getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo networkInfo = connectivityManager.getActiveNetworkInfo();
    isConnected = (networkInfo != null && networkInfo.isConnectedOrConnecting());

    return isConnected;
  }
}
