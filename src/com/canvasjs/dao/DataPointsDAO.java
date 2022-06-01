package com.canvasjs.dao;

import java.util.List;
import com.canvasjs.model.DataPointsModel;
import javax.sql.DataSource;

public interface DataPointsDAO 
{
    public void setDataSource(DataSource ds);
    public List<DataPointsModel> getMemoryDataPoints();
    public List<DataPointsModel> getCPUDataPoints();
    public List<DataPointsModel> getDISKDataPoints();    
}