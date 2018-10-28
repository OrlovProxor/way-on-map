package com.orlov_prokhor.wayonmap.presentation.view.activity;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import com.orlov_prokhor.wayonmap.presentation.AndroidApplication;
import com.orlov_prokhor.wayonmap.presentation.internal.di.components.ApplicationComponent;

/**
 * Base {@link android.app.Activity} class for every Activity in this application.
 */
public abstract class BaseActivity extends AppCompatActivity {


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    this.getApplicationComponent().inject(this);
  }




  protected ApplicationComponent getApplicationComponent() {
    return ((AndroidApplication) getApplication()).getApplicationComponent();
  }


}
