package com.frontend.model;

import com.frontend.services.DataPointsMapper;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.List;
import javax.sql.DataSource;
import org.json.JSONArray;
import org.json.JSONException;
import org.springframework.jdbc.core.JdbcTemplate;

public class CanvasjsChartData {

  static JSONArray json = null;

  public static String getCanvasjsDataList() {
    return json.toString();
  }
}
