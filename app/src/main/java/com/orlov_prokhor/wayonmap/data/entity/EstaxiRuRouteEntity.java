package com.orlov_prokhor.wayonmap.data.entity;

import com.orlov_prokhor.wayonmap.data.entity.PathPointEntity;
import java.util.List;

import com.google.gson.annotations.SerializedName;


public class EstaxiRuRouteEntity {

	@SerializedName("coords")
	public   List<PathPointEntity> coords;
}