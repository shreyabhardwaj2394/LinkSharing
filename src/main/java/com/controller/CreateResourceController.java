package com.controller;

import com.dao.TopicDaoImpl;
import com.model.*;
import com.service.ResourceServiceImpl;
import com.service.SubscriptionServiceImpl;
import com.service.TopicServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

/**
 * Created by Shreya on 7/18/2017.
 */
@Controller
public class CreateResourceController {


    ResourceServiceImpl resourceService=new ResourceServiceImpl();

    TopicDaoImpl topicDao=new TopicDaoImpl();

    TopicServiceImpl topicService=new TopicServiceImpl();

    SubscriptionServiceImpl subscriptionService=new SubscriptionServiceImpl();

    @RequestMapping(value = "/createLinkResource", method = RequestMethod.POST)
    public ModelAndView createLinkResource(@ModelAttribute LinkResource linkResourceDTO,@RequestParam Integer topicvalue
                                            , HttpServletRequest request) {

        if (topicvalue == 0) {
            ModelAndView selectSomething = new ModelAndView("selectSomething");
            return selectSomething;
        }
        else {


            User user = (User) request.getSession().getAttribute("userDTO");

            boolean status = resourceService.saveLinkResource(linkResourceDTO, user, topicvalue);

            ModelAndView modelAndView = new ModelAndView("dashboard");
            ModelAndView error = new ModelAndView("error");

            if (status == true) {
                modelAndView.addObject("username", user.getUsername());
                modelAndView.addObject("first", user.getFirstName());
                modelAndView.addObject("last", user.getLastName());
                Map<String, Integer> topicmap = topicService.TopicCount(request);
                modelAndView.addObject("TopicCount", topicmap.get("TopicCount"));
                Map<String, Integer> subscriptionmap = subscriptionService.subscriptionCount(request);
                modelAndView.addObject("SubscriptionCount", subscriptionmap.get("SubscriptionCount"));
                modelAndView.addObject("topiclist", topicDao.getSubscribedTopics(user));
                List<Subscription> subscriptionList = subscriptionService.getSubscriptionList(request);
                modelAndView.addObject("subscriptionList", subscriptionList);
                List<Topic> topicList = topicService.getCreatedTopicList(request);
                modelAndView.addObject("createdTopicList", topicList);
                return modelAndView;
            } else
                return error;
        }
    }


    @RequestMapping(value = "/createDocumentResource", method = RequestMethod.POST)
    public ModelAndView createDocumentResource(@ModelAttribute DocumentResource documentResourceDTO,
                                               @RequestParam MultipartFile file,@RequestParam Integer topicvalue, HttpServletRequest request) throws MalformedURLException {

        URL url = new URL(request.getRequestURL().toString());
        System.out.println("namee" + file.getOriginalFilename());
        String path = request.getContextPath();
        System.out.println("url is:" + url);
        System.out.println("path is:" + path);
        User user = (User) request.getSession().getAttribute("userDTO");

        if (topicvalue == 0) {
            ModelAndView selectSomething = new ModelAndView("selectSomething");
            return selectSomething;
        } else {
            boolean status = resourceService.saveDocumentResource(documentResourceDTO, file, topicvalue, user);

            ModelAndView modelAndView = new ModelAndView("dashboard");
            ModelAndView error = new ModelAndView("error");

            if (status == true) {

                modelAndView.addObject("username", user.getUsername());
                modelAndView.addObject("first", user.getFirstName());
                modelAndView.addObject("last", user.getLastName());
                Map<String, Integer> topicmap = topicService.TopicCount(request);
                modelAndView.addObject("TopicCount", topicmap.get("TopicCount"));
                Map<String, Integer> subscriptionmap = subscriptionService.subscriptionCount(request);
                modelAndView.addObject("SubscriptionCount", subscriptionmap.get("SubscriptionCount"));
                modelAndView.addObject("topiclist", topicDao.getSubscribedTopics(user));
                List<Subscription> subscriptionList = subscriptionService.getSubscriptionList(request);
                modelAndView.addObject("subscriptionList", subscriptionList);
                List<Topic> topicList = topicService.getCreatedTopicList(request);
                modelAndView.addObject("createdTopicList", topicList);

                return modelAndView;
            } else
                return error;


        }
    }

}
