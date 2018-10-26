package com.orlov_prokhor.wayonmap.presentation.view.activity;


import android.arch.lifecycle.ViewModelProviders;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.UiSettings;
import com.orlov_prokhor.wayonmap.R;
import com.orlov_prokhor.wayonmap.databinding.ActivityMainBinding;
import com.orlov_prokhor.wayonmap.presentation.view.presenter.PathPointsActivityViewModel;
import com.orlov_prokhor.wayonmap.presentation.view.presenter.PathPointsActivityViewModelImpl;


public class PathPointsActivity extends BaseActivity implements OnMapReadyCallback {

  ActivityMainBinding         binding;
  PathPointsActivityViewModel viewModel;


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
    viewModel = ViewModelProviders.of(this).get(PathPointsActivityViewModelImpl.class);
    binding.setViewModel(viewModel);


    mapViewInit(savedInstanceState);


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
    super.onDestroy();
  }

  @Override
  public void onLowMemory() {
    super.onLowMemory();
    binding.mapView.onLowMemory();
  }
}
