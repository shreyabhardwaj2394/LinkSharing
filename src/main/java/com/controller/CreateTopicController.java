package com.controller;

import com.dao.UserDaoImpl;
import com.model.Topic;
import com.model.User;
import com.service.TopicServiceImpl;
import com.utils.enums.Seriousness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;




@Controller
public class CreateTopicController {

    TopicServiceImpl topicService=new TopicServiceImpl();


    @RequestMapping(value = "/createTopic", method = RequestMethod.POST)
    public ModelAndView createTopic(@ModelAttribute Topic topic, HttpServletRequest request,
                                    HttpServletResponse response) {
        String username=(String) request.getSession().getAttribute("username");
        System.out.println("current user"+username);
         ModelAndView modelAndView=new ModelAndView("dashboard");
         ModelAndView error=new ModelAndView("error");
        boolean status = topicService.saveTopic(topic,username);
       if (status==true) {
            //subscribeTopic(id, Seriousness.VERY_SERIOUS, request, response);
            return modelAndView;
        } else {
            return error;
        }
    }
}
