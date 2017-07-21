package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shreya on 7/21/2017.
 */

@Controller
public class ViewPostsController {

    @RequestMapping(value = "/viewPosts",method = RequestMethod.GET)
    public ModelAndView view(){
        ModelAndView resource=new ModelAndView("viewpost");
        return resource;
    }
}
