package com.frontend.controllers;

import com.frontend.dao.DataPointsDAOImpl;
import com.frontend.services.CanvasjsChartService;
import com.frontend.services.RestfullDataPointsService;
import java.io.PrintWriter;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping(value = "/restfull-service")
public class RestController extends HttpServlet {

  private static final long serialVersionUID = 1L;

  @Autowired
  private CanvasjsChartService canvasjsChartService;

  @RequestMapping(
    value = "/eBay-inc-stock-price.json",
    method = RequestMethod.GET
  )
  public @ResponseBody void getDataPoints(
    HttpServletRequest request,
    HttpServletResponse response
  )
    throws Exception {
    RestfullDataPointsService dpService = new RestfullDataPointsService();
    PrintWriter out = response.getWriter();
    out.println(dpService.outputJson(getDataFromDB()));
  }
}
