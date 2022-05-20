package com.frontend.dao;

import com.frontend.model.CanvasjsChartData;

public class CanvasjsChartDaoImpl implements CanvasjsChartDao {

  @Override
  public String getCanvasjsChartData() {
    return CanvasjsChartData.getCanvasjsDataList();
  }
}
