package com.controller;

import com.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Shreya on 7/21/2017.
 */
@Controller
public class TopicShowController {
    @RequestMapping(value = "/topicShow",method = RequestMethod.GET)
    public ModelAndView  topicShow(HttpServletRequest request){
        ModelAndView topicShow=new ModelAndView("topicShow");
        User sessionUser=(User)request.getSession().getAttribute("userDTO");
        topicShow.addObject("first",sessionUser.getFirstName());
        return topicShow;
    }
}
