package com.canvasjs.controllers;

import com.canvasjs.dao.DataPointsDAOImpl;
import com.canvasjs.model.DataPointsModel;
import com.google.gson.Gson;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.naming.NamingException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping(value = "/chart-types", method = RequestMethod.GET)
public class ChartTypesController {

    @RequestMapping(value = "/line1", method = RequestMethod.GET)
    public ModelAndView Memory() throws NamingException, SQLException {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DataPointsDAOImpl dataPoints = (DataPointsDAOImpl) context.getBean("DataPointsDAOImpl");
        Gson gsonObj = new Gson();

        ModelAndView modelAndView = new ModelAndView("ChartTypes/Line1");
        modelAndView.addObject("title", "Memory");
        modelAndView.addObject("dataPoints", gsonObj.toJson(dataPoints.getMemoryDataPoints()));
        return modelAndView;
    }

    @RequestMapping(value = "/line2", method = RequestMethod.GET)
    public ModelAndView CPU() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DataPointsDAOImpl dataPoints = (DataPointsDAOImpl) context.getBean("DataPointsDAOImpl");
        Gson gsonObj = new Gson();

        ModelAndView modelAndView = new ModelAndView("ChartTypes/Line2");
        modelAndView.addObject("title", "CPU");
        modelAndView.addObject("dataPoints", gsonObj.toJson(dataPoints.getCPUDataPoints()));
        return modelAndView;
    }

    @RequestMapping(value = "/line3", method = RequestMethod.GET)
    public ModelAndView DISK() {
        ApplicationContext context = new ClassPathXmlApplicationContext("beans.xml");
        DataPointsDAOImpl dataPoints = (DataPointsDAOImpl) context.getBean("DataPointsDAOImpl");
        Gson gsonObj = new Gson();

        ModelAndView modelAndView = new ModelAndView("ChartTypes/Line3");
        modelAndView.addObject("title", "DISK");
        modelAndView.addObject("dataPoints", gsonObj.toJson(dataPoints.getDISKDataPoints()));
        return modelAndView;
    }

}
