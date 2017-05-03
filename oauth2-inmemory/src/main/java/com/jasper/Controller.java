package com.jasper;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by jjiang153 on 2017/4/1.
 */

@RestController
@RequestMapping("/api")
public class Controller {
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public String userlist() {
        return "user/list";
    }
}
