package com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Date;

/**
 * @author cj
 * @date 2019/11/12
 */

@Controller
@RequestMapping("/formatter")
public class Date1FormatterController {

    @Autowired(required = false)
    private ConversionService conversionService;

    @GetMapping("/date")
    public String receiveDate(@DateTimeFormat(pattern = "yyyy-MM-dd") Date date) {
        System.out.println("-----debug: conversionService = " + conversionService);
        System.out.println("-----debug: date = " + date);
        return "index";
    }




}
