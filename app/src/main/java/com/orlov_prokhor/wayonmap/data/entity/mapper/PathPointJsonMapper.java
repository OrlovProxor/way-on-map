package com.orlov_prokhor.wayonmap.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.orlov_prokhor.wayonmap.data.entity.PathPointEntity;
import com.orlov_prokhor.wayonmap.data.entity.ServerResponse;
import java.util.List;
import javax.inject.Inject;


/**
 * Class used to transform from Strings representing json to valid objects.
 */
public class PathPointJsonMapper {

  private final Gson gson;

  @Inject
  public PathPointJsonMapper() {
    this.gson = new Gson();
  }


  public List<PathPointEntity> transformPathPointCollection(String userListJsonResponse)
  throws JsonSyntaxException {
    return gson.fromJson(userListJsonResponse, ServerResponse.class).coords;
  }
}
