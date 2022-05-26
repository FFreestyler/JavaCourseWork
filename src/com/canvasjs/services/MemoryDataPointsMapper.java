package com.canvasjs.services;

import com.canvasjs.model.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import org.springframework.jdbc.core.RowMapper;

public class MemoryDataPointsMapper implements RowMapper<DataPointsModel> {
	public DataPointsModel mapRow(ResultSet rs, int rowNum) throws SQLException {
		DataPointsModel dpModel = new DataPointsModel();
		dpModel.setX(rs.getFloat("id"));
		dpModel.setY(rs.getFloat("mem"));
	      return dpModel;
	   }
}
