package com.canvasjs.dao;

import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.canvasjs.model.DataPointsModel;
import com.canvasjs.services.CPUDataPointsMapper;
import com.canvasjs.services.DISKDataPointsMapper;
import com.canvasjs.services.MemoryDataPointsMapper;

public class DataPointsDAOImpl implements DataPointsDAO {
	private DataSource dataSource;
	private JdbcTemplate jdbcTemplateObject;
        
        
        @Override
	public void setDataSource(DataSource dataSource) {
	      this.dataSource = dataSource;
	      this.jdbcTemplateObject = new JdbcTemplate(dataSource);
	   }
	
        @Override
	public List<DataPointsModel> getMemoryDataPoints() {
		String SQL = "select id,mem from usage";
		List<DataPointsModel> dataPoints = jdbcTemplateObject.query(SQL, new MemoryDataPointsMapper());
		return dataPoints;
	}
        
        @Override
        public List<DataPointsModel> getCPUDataPoints() {
		String SQL = "select id,cpu from usage";
		List<DataPointsModel> dataPoints = jdbcTemplateObject.query(SQL, new CPUDataPointsMapper());
		return dataPoints;
	}
        
        @Override
        public List<DataPointsModel> getDISKDataPoints() {
		String SQL = "select id,disk from usage";
		List<DataPointsModel> dataPoints = jdbcTemplateObject.query(SQL, new DISKDataPointsMapper());
		return dataPoints;
	}
}
