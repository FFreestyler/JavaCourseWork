package com.frontend.services;

import com.frontend.model.DataPointsModel;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RestfullDataPointsService {

  public List<Map<Object, Object>> getDataFromDB(List<DataPointsModel> data) {
    List<Map<Object, Object>> dataPoints = new ArrayList<Map<Object, Object>>();

    for (int i = 0; i < data.size(); i++) {
      Map<Object, Object> dataPoint = new HashMap<Object, Object>();
      dataPoint.put("x", data.get(i).getX());
      dataPoint.put("y", data.get(i).getY());
      dataPoints.add(dataPoint);
    }
    return dataPoints;
  }

  public String outputJson(List<Map<Object, Object>> dataPoints) {
    Gson gsonObj = new Gson();
    return gsonObj.toJson(dataPoints);
  }
}
