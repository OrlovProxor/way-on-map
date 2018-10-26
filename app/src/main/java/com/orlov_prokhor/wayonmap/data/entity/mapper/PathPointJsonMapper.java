package com.orlov_prokhor.wayonmap.data.entity.mapper;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import com.google.gson.reflect.TypeToken;
import com.orlov_prokhor.wayonmap.data.entity.PathPointEntity;
import java.lang.reflect.Type;
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
    final Type listOfUserEntityType = new TypeToken<List<PathPointEntity>>() {}.getType();
    return this.gson.fromJson(userListJsonResponse, listOfUserEntityType);
  }
}
