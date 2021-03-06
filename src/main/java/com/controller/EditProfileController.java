package com.controller;

/**
 * Created by Shreya on 7/20/2017.
 */

import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.service.SubscriptionServiceImpl;
import com.service.TopicServiceImpl;
import com.service.UserServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.Map;

@Controller
public class EditProfileController {

    TopicServiceImpl topicService=new TopicServiceImpl();
    SubscriptionServiceImpl subscriptionService=new SubscriptionServiceImpl();
    UserServiceImpl userService=new UserServiceImpl();


    @RequestMapping(value = "/editprofile",method = RequestMethod.GET)
    public ModelAndView profile(HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("editprofile");
        User sessionUser=(User)request.getSession().getAttribute("userDTO");

        modelAndView.addObject("username",sessionUser.getUsername());
        modelAndView.addObject("first",sessionUser.getFirstName());
        modelAndView.addObject("last",sessionUser.getLastName());
        Map<String,Integer> topicmap=topicService.TopicCount(request);
        modelAndView.addObject("TopicCount",topicmap.get("TopicCount"));
        Map<String,Integer> subscriptionmap=subscriptionService.subscriptionCount(request);
        modelAndView.addObject("SubscriptionCount",subscriptionmap.get("SubscriptionCount"));
        List<Subscription> subscriptionList=subscriptionService.getSubscriptionList(request);
        modelAndView.addObject("subscriptionList",subscriptionList);
        modelAndView.addObject("topiclist",topicService.getSubscribedTopics(sessionUser));
        List<Topic> topicList=topicService.getCreatedTopicList(request);
        modelAndView.addObject("createdTopicList",topicList);
        List<Topic> createdTopicList=topicService.getCreatedTopicList(request);
        modelAndView.addObject("createdTopicList",createdTopicList);
        List<Topic> publicTopicList=topicService.getPublicTopics();
        modelAndView.addObject("publicTopics",publicTopicList);
        return modelAndView;
    }


    @RequestMapping(value = "/updatePassword",method = RequestMethod.POST)
    public ModelAndView changePassword(@RequestParam String password,
                                       HttpServletRequest request){
        ModelAndView passwordchanged=new ModelAndView("updated");
        ModelAndView error=new ModelAndView("error");

        boolean status=userService.updatePassword(password,request);

        if(status==true)
            return passwordchanged;
        else
            return error;
    }

    @RequestMapping(value = "/updateDetails",method = RequestMethod.POST)
    public ModelAndView updateInfo(User user, @RequestParam CommonsMultipartFile file,HttpServletRequest request){
        byte[] photo=null;
        if(!file.isEmpty())
            photo=file.getBytes();
        boolean status=userService.updateDetails(user,photo,request);
        ModelAndView updated=new ModelAndView("updated");
        ModelAndView error=new ModelAndView("error");

        if(status==true)

            return updated;
        else
            return error;
    }


}
