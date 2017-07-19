package com.controller;

import com.dao.TopicDaoImpl;
import com.model.User;
import com.service.UniqueusernameService;
import com.service.UniqueusernameServiceImpl;
import com.service.UserServiceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Shreya on 7/14/2017.
 */
@Controller
public class LoginController {

    @Autowired
    private UniqueusernameService uniqueusernameService;
    @Autowired
    UserServiceImpl userService;
    @Autowired
    TopicDaoImpl topicDao;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public ModelAndView registeredUser(@ModelAttribute User user, HttpServletRequest request, HttpServletResponse response){
        ModelAndView modelAndView=new ModelAndView("dashboard");
        String username=user.getUsername();
        //System.out.println("username"+username);

        ModelAndView modelAndView_fail=new ModelAndView("index");

        UserServiceImpl userService=new UserServiceImpl();
        boolean state=userService.login(user,request,response);

        System.out.println(state);


        User sessionUser=(User)request.getSession().getAttribute("userDTO");
        modelAndView.addObject("username",sessionUser.getFirstName());

        //Topic test;
        //for checking
        if(state==true) {
            System.out.println("List is:");
            List list=topicDao.getSubscribedTopics(user);
            ListIterator itr=list.listIterator();
            while (itr.hasNext()){

                System.out.println(itr.next());
            }

            //for el to use
            modelAndView.addObject("topiclist",topicDao.getSubscribedTopics(user));


            return modelAndView;
        }
        else
            return modelAndView_fail;
    }


    @RequestMapping(value = "/uniqueusername",method = RequestMethod.POST)
    public @ResponseBody
    String checkusername(HttpServletRequest request, HttpServletResponse response)throws Exception
    {

        //System.out.println("valuuueeee    "+request.getParameter("val"));
       return  uniqueusernameService.checkavailability(request.getParameter("val"));

    }
}
