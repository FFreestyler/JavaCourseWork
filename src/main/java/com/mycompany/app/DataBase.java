package com.mycompany.app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;

public class DataBase {

  Connection conn = null;

  public void pushRecords(Double CPUUsage, Double MEMUsage, String DISKUsage) {
    String sql = "INSERT INTO usage(cpu,mem,disk) VALUES(?,?,?)";

    try (PreparedStatement pstmt = conn.prepareStatement(sql)) {
      pstmt.setDouble(1, CPUUsage);
      pstmt.setDouble(2, MEMUsage);
      pstmt.setString(3, DISKUsage);
      pstmt.executeUpdate();
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void createNewTable() {
    String sql =
      "CREATE TABLE IF NOT EXISTS usage (\n" +
      "	id integer PRIMARY KEY,\n" +
      "	cpu real,\n" +
      "	mem real,\n" +
      "	disk text\n" +
      ");";

    try (Statement stmt = conn.createStatement()) {
      stmt.execute(sql);
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    }
  }

  public void connect() {
    try {
      String url = "jdbc:sqlite:database.db";
      conn = DriverManager.getConnection(url);

      System.out.println("Connection to SQLite has been established.");
    } catch (SQLException e) {
      System.out.println(e.getMessage());
    } finally {
      if (conn != null) {
        //conn.close();
      }
    }
  }
}
