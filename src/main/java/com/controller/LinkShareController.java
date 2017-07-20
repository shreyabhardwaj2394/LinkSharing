package com.controller;


import com.model.Resource;
import com.model.Topic;
import com.model.User;
import com.service.ResourceServiceImpl;
import com.service.TopicServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;
import java.util.ListIterator;
import java.util.Map;


/**
 * Created by Shreya on 7/10/2017.
 */
@Controller
public class LinkShareController {

    @Autowired
    TopicServiceImpl topicService;
    @Autowired
    ResourceServiceImpl resourceService;

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView reach() {
        ModelAndView modelAndView=new ModelAndView("index");


        List<Resource> resourceList=resourceService.getPublic();
        modelAndView.addObject("resourceList",resourceList);
        return modelAndView;
    }
}
