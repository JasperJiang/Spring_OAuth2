package com.jasper.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jjiang153 on 2017/5/3.
 */
@RestController
@RequestMapping("/api")
public class MainController {
    @RequestMapping(value = "/test",method = RequestMethod.GET)
    public String test(){
        return "SUCCESS!!!!";
    }
}
