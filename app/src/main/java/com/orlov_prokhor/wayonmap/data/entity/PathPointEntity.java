package com.orlov_prokhor.wayonmap.data.entity;

import com.google.gson.annotations.SerializedName;


public class PathPointEntity {

  @SerializedName("la")
  private double latitude;
  @SerializedName("lo")
  private double longitude;

  public double getLatitude() {
    return latitude;
  }

  public void setLatitude(double latitude) {
    this.latitude = latitude;
  }

  public double getLongitude() {
    return longitude;
  }

  public void setLongitude(double longitude) {
    this.longitude = longitude;
  }
}
