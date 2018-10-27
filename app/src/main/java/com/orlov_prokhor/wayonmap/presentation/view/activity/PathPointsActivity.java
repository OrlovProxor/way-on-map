package com.orlov_prokhor.wayonmap.presentation.view.activity;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.databinding.Observable;
import android.databinding.Observable.OnPropertyChangedCallback;
import android.graphics.Color;
import android.os.Bundle;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.PolylineOptions;
import com.orlov_prokhor.wayonmap.R;
import com.orlov_prokhor.wayonmap.databinding.ActivityMainBinding;
import com.orlov_prokhor.wayonmap.domain.PathPoint;
import com.orlov_prokhor.wayonmap.presentation.view.presenter.PathPointsActivityViewModel;
import com.orlov_prokhor.wayonmap.presentation.view.presenter.PathPointsActivityViewModelImpl;
import java.util.ArrayList;
import java.util.List;


public class PathPointsActivity extends BaseActivity implements OnMapReadyCallback {

  private ActivityMainBinding         binding;
  private PathPointsActivityViewModel viewModel;
  private OnPropertyChangedCallback   onPathPointListChangedCallback;
  private GoogleMap                   googleMap;

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    viewModel = ViewModelProviders.of(this).get(PathPointsActivityViewModelImpl.class);
    binding.setActivity(this);

    mapViewInit(savedInstanceState);
    pathPointListInitObservable();
  }

  private void mapViewInit(Bundle savedInstanceState) {

    Bundle mapViewBundle = null;
    if (savedInstanceState != null) {
      mapViewBundle = savedInstanceState.getBundle(getString(R.string.google_maps_key));
    }
    binding.mapView.onCreate(mapViewBundle);
    binding.mapView.getMapAsync(this);
  }

  @Override
  public void onMapReady(GoogleMap googleMap) {

    UiSettings uiSettings = googleMap.getUiSettings();
    uiSettings.setIndoorLevelPickerEnabled(true);
    uiSettings.setMyLocationButtonEnabled(true);
    uiSettings.setMapToolbarEnabled(true);
    uiSettings.setCompassEnabled(true);
    uiSettings.setZoomControlsEnabled(true);

    binding.btnShowPath.setEnabled(true);
    this.googleMap = googleMap;
    showPathPointList();
  }

  private void pathPointListInitObservable() {
    onPathPointListChangedCallback = new OnPropertyChangedCallback() {
      @Override
      public void onPropertyChanged(Observable sender, int propertyId) {
        showPathPointList();
      }
    };
    viewModel.getPathPointList().addOnPropertyChangedCallback(onPathPointListChangedCallback);
  }

  private void showPathPointList() {
    List<PathPoint> pathPointList = viewModel.getPathPointList().get();
    if (pathPointList == null) {
      return;
    }
    if (pathPointList.size() < 2) {
      return;
    }
    List<LatLng> lstLatLngRoute = new ArrayList<>();
    for (PathPoint point : pathPointList) {
      LatLng ll = new LatLng(point.getLatitude(), point.getLongitude());
      lstLatLngRoute.add(ll);
    }

    drawPrimaryLinePath(lstLatLngRoute);
    zoomRoute(googleMap, lstLatLngRoute);
  }

  private void drawPrimaryLinePath(List<LatLng> listLocsToDraw) {
    //https://stackoverflow.com/questions/16262837/how-to-draw-route-in-google-maps-api-v2-from-my-location
    if (googleMap == null) {
      return;
    }

    if (listLocsToDraw.size() < 2) {
      return;
    }

    PolylineOptions options = new PolylineOptions();

    options.color(Color.parseColor("#CC0000FF"));
    options.width(5);
    options.visible(true);

    for (LatLng locRecorded : listLocsToDraw) {
      options.add(locRecorded);
    }

    googleMap.addPolyline(options);

  }

  private void zoomRoute(GoogleMap googleMap, List<LatLng> lstLatLngRoute) {
    //https://stackoverflow.com/questions/39656911/zoom-over-specific-route-google-map
    if (googleMap == null || lstLatLngRoute == null || lstLatLngRoute.isEmpty()) {
      return;
    }

    LatLngBounds.Builder boundsBuilder = new LatLngBounds.Builder();
    for (LatLng latLngPoint : lstLatLngRoute) {
      boundsBuilder.include(latLngPoint);
    }

    int          routePadding = 100;
    LatLngBounds latLngBounds = boundsBuilder.build();

    googleMap.moveCamera(CameraUpdateFactory.newLatLngBounds(latLngBounds, routePadding));
  }

  public void showPath() {
    viewModel.showPath();
  }


  @Override
  public void onResume() {
    super.onResume();
    binding.mapView.onResume();
  }

  @Override
  public void onStart() {
    super.onStart();
    binding.mapView.onStart();
  }

  @Override
  public void onStop() {
    super.onStop();
    binding.mapView.onStop();
  }

  @Override
  public void onPause() {
    binding.mapView.onPause();
    super.onPause();
  }

  @Override
  public void onDestroy() {
    binding.mapView.onDestroy();
    viewModel.getPathPointList().removeOnPropertyChangedCallback(onPathPointListChangedCallback);
    super.onDestroy();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    binding.mapView.onLowMemory();
  }

}
