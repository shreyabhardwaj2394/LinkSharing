/*
package com.utils;

import com.model.User;
import com.service.ResourceServiceImpl;
import com.service.TopicServiceImpl;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

*/
/**
 * Created by Shreya on 7/19/2017.
 *//*

public class ViewGenerator {

        TopicServiceImpl topicService=new TopicServiceImpl();
        ResourceServiceImpl resourceService=new ResourceServiceImpl();

        public ModelAndView getView(HttpServletRequest request) {
        ModelAndView modelAndView;
        User userDTO = (User) request.getSession().getAttribute("userDTO");
        if (userDTO == null) {
            modelAndView = new ModelAndView("index");
            //modelAndView.addObject("resourceDTOs", resourceService.getResourceDTOs());
        } else {
            modelAndView = new ModelAndView("dashboard");
            // modelAndView.addObject("userDTO", userDTO);
            modelAndView.addObject("topicDTOs", topicService.getTopicDTOs());
            modelAndView.addObject("resourceDTOs", resourceService.getResourceDTOs());
        }
        return modelAndView;
    }
}
*/
