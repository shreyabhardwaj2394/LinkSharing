package com.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * Created by Shreya on 7/10/2017.
 */
@Controller
public class LinkShareController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String reach() {
        return "index";
    }
}
