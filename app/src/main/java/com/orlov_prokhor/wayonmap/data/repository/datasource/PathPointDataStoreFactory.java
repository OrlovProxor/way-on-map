package com.orlov_prokhor.wayonmap.data.repository.datasource; /**
 * Copyright (C) 2015 Fernando Cejas Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */


import android.content.Context;
import android.support.annotation.NonNull;
import com.orlov_prokhor.wayonmap.data.entity.mapper.PathPointJsonMapper;
import com.orlov_prokhor.wayonmap.data.net.RestApi;
import com.orlov_prokhor.wayonmap.data.net.RestApiImpl;
import javax.inject.Inject;
import javax.inject.Singleton;


@Singleton
public class PathPointDataStoreFactory {

  private final Context context;


  @Inject
  public PathPointDataStoreFactory(@NonNull Context context) {
    this.context = context.getApplicationContext();

  }


  public PathPointDataStore createCloudDataStore() {
    final PathPointJsonMapper userEntityJsonMapper = new PathPointJsonMapper();
    final RestApi restApi = new RestApiImpl(this.context,
                                            userEntityJsonMapper);

    return new NetPathPointDataStore(restApi);
  }
}
