package com.controller;

import com.dao.TopicDaoImpl;
import com.dao.UserDaoImpl;
import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.service.SubscriptionServiceImpl;
import com.service.TopicServiceImpl;
import com.utils.enums.Seriousness;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;


@Controller
public class CreateTopicController {
    @Autowired
    TopicServiceImpl topicService;
    @Autowired
    SubscriptionServiceImpl subscriptionService;
    @Autowired
    TopicDaoImpl topicDao;


    @RequestMapping(value = "/createTopic", method = RequestMethod.POST)
    public ModelAndView createTopic(@ModelAttribute Topic topic, HttpServletRequest request,
                                    HttpServletResponse response) {

        User user = (User) request.getSession().getAttribute("userDTO");

         ModelAndView modelAndView=new ModelAndView("dashboard");
         ModelAndView error=new ModelAndView("error");

         int topicId = topicService.saveTopic(topic,user);

       if (topicId!=0) {
           subscribeTopic(topicId,Seriousness.VERY_SERIOUS, request, response);

           modelAndView.addObject("username",user.getUsername());
           modelAndView.addObject("first",user.getFirstName());
           modelAndView.addObject("last",user.getLastName());
           Map<String,Integer> topicmap=topicService.TopicCount(request);
           modelAndView.addObject("TopicCount",topicmap.get("TopicCount"));
           Map<String,Integer> subscriptionmap=subscriptionService.subscriptionCount(request);
           modelAndView.addObject("SubscriptionCount",subscriptionmap.get("SubscriptionCount"));
           modelAndView.addObject("topiclist",topicDao.getSubscribedTopics(user));
           List<Subscription> subscriptionList=subscriptionService.getSubscriptionList(request);
           modelAndView.addObject("subscriptionList",subscriptionList);
           List<Topic> topicList=topicService.getCreatedTopicList(request);
           modelAndView.addObject("createdTopicList",topicList);
            return modelAndView;
        } else {
            return error;
        }
    }

    @RequestMapping(value = "/subscribeTopic")
    public ModelAndView subscribeTopic(@RequestParam(value = "topicId", required = true) Integer topicId,
                                       @RequestParam(value = "seriousness", required = true) Seriousness seriousness, HttpServletRequest request,
                                       HttpServletResponse response) {
        boolean status=false;
        //String username=(String) request.getSession().getAttribute("username");
        User user = (User) request.getSession().getAttribute("userDTO");
        ModelAndView modelAndView=new ModelAndView("dashboard");
        ModelAndView error=new ModelAndView("error");
        if (user != null) {
            status = subscriptionService.saveSubscription(topicId, user, seriousness);
        }
        if (status==true) {

            modelAndView.addObject("topiclist",topicDao.getSubscribedTopics(user));


            User sessionUser=(User)request.getSession().getAttribute("userDTO");
            modelAndView.addObject("username",sessionUser.getFirstName());

            return modelAndView;
        } else {
            return error;
        }
    }

}
