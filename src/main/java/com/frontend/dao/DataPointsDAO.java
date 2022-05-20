package com.frontend.dao;

import com.frontend.model.DataPointsModel;
import java.util.List;
import javax.sql.DataSource;

public interface DataPointsDAO {
  public List<DataPointsModel> getDataPoints();

  public void setDataSource(DataSource ds);
}
