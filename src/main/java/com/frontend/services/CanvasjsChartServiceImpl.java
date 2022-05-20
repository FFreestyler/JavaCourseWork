package com.frontend.services;

import com.frontend.dao.CanvasjsChartDao;
import org.springframework.beans.factory.annotation.Autowired;

public class CanvasjsChartServiceImpl implements CanvasjsChartService {

  @Autowired
  private CanvasjsChartDao canvasjsChartDao;

  public void setCanvasjsChartDao(CanvasjsChartDao canvasjsChartDao) {
    this.canvasjsChartDao = canvasjsChartDao;
  }

  @Override
  public String getCanvasjsChartData() {
    return canvasjsChartDao.getCanvasjsChartData();
  }
}
