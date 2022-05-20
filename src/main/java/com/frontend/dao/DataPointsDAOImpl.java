package com.frontend.dao;

import com.frontend.model.DataPointsModel;
import com.frontend.services.DataPointsMapper;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;
import javax.sql.DataSource;
import org.springframework.jdbc.core.JdbcTemplate;

public class DataPointsDAOImpl {

  Connection conn = null;

  private DataSource dataSource;
  private JdbcTemplate jdbcTemplateObject;

  public void setDataSource(DataSource dataSource) {
    this.dataSource = dataSource;
    this.jdbcTemplateObject = new JdbcTemplate(dataSource);
  }

  public void connect() {
    try {
      String url = "jdbc:sqlite:database.db";
      conn = DriverManager.getConnection(url);

      System.out.println("Connection to SQLite has been established.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (conn != null) {}
    }
  }

  public List<DataPointsModel> getDataPointsDAO() {
    String SQL = "SELECT id,cpu FROM 'usage'";
    List<DataPointsModel> dataPoints = jdbcTemplateObject.query(
      SQL,
      new DataPointsMapper()
    );
    return dataPoints;
  }
}
