package com.controller;

import com.dao.TopicDaoImpl;
import com.dao.UserDaoImpl;
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
       // String username=(String) request.getSession().getAttribute("username");
        User user = (User) request.getSession().getAttribute("userDTO");
        //System.out.println("current user"+username);
         ModelAndView modelAndView=new ModelAndView("dashboard");
         ModelAndView error=new ModelAndView("error");
        int topicId = topicService.saveTopic(topic,user);



       if (topicId!=0) {
           subscribeTopic(topicId,Seriousness.VERY_SERIOUS, request, response);

           System.out.println("List is:");
           List list=topicDao.getSubscribedTopics(user);
           ListIterator itr=list.listIterator();
           while (itr.hasNext()){

               System.out.println(itr.next());
           }
           modelAndView.addObject("topiclist",topicDao.getSubscribedTopics(user));


           User sessionUser=(User)request.getSession().getAttribute("userDTO");
           modelAndView.addObject("username",sessionUser.getFirstName());

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
