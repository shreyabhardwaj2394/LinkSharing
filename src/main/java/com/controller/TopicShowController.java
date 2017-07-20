package com.controller;

import com.model.Resource;
import com.model.Topic;
import com.model.User;
import com.service.ResourceServiceImpl;
import com.service.TopicServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Shreya on 7/21/2017.
 */
@Controller
public class TopicShowController {
    ResourceServiceImpl resourceService=new ResourceServiceImpl();
    @RequestMapping(value = "/topicShow/{topicName}",method = RequestMethod.GET)
    public ModelAndView  topicShow(HttpServletRequest request,
                                   @PathVariable("topicName")String topicName){
        ModelAndView topicShow=new ModelAndView("topicShow");
        User sessionUser=(User)request.getSession().getAttribute("userDTO");
        topicShow.addObject("first",sessionUser.getFirstName());
        topicShow.addObject("topicName",topicName);

        List<Resource> resourceList=resourceService.getResourcesForTopic(topicName);
        for(Resource resource:resourceList){
            System.out.println("res"+resource.getDescription());
        }
        topicShow.addObject("resourceList",resourceList);

        return topicShow;
    }
}
