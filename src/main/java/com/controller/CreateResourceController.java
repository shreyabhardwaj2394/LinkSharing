package com.controller;

import com.dao.TopicDaoImpl;
import com.model.*;
import com.service.ResourceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by Shreya on 7/18/2017.
 */
@Controller
public class CreateResourceController {

    ResourceServiceImpl resourceService=new ResourceServiceImpl();
    TopicDaoImpl topicDao=new TopicDaoImpl();

    @RequestMapping(value = "/createLinkResource", method = RequestMethod.POST)
    public ModelAndView createLinkResource(@ModelAttribute LinkResource linkResourceDTO,@RequestParam Integer topicvalue
                                            , HttpServletRequest request,
                                           HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("userDTO");
        //linkResourceDTO.setCreatedBy(userDTO);

       // System.out.println("des"+linkResourceDTO.getDescription());
        boolean status = resourceService.saveLinkResource(linkResourceDTO,user,topicvalue);

        ModelAndView modelAndView=new ModelAndView("dashboard");
        ModelAndView error=new ModelAndView("error");

        if(status==true) {

            modelAndView.addObject("topiclist",topicDao.getSubscribedTopics(user));


            User sessionUser=(User)request.getSession().getAttribute("userDTO");
            modelAndView.addObject("username",sessionUser.getFirstName());

            return modelAndView;
        }
        else
            return error;
    }



    @RequestMapping(value = "/createDocumentResource", method = RequestMethod.POST)
    public ModelAndView createDocumentResource(@ModelAttribute DocumentResource documentResourceDTO,
                                               @RequestParam MultipartFile file,@RequestParam Integer topicvalue, HttpServletRequest request,
                                               HttpServletResponse response) throws MalformedURLException {

        URL url = new URL(request.getRequestURL().toString());
        System.out.println("namee"+file.getOriginalFilename());
        String path = request.getContextPath();
        System.out.println("url is:"+url);
        System.out.println("path is:"+path);
        User userDTO = (User) request.getSession().getAttribute("userDTO");

       boolean status = resourceService.saveDocumentResource(documentResourceDTO,file,topicvalue,userDTO);

        ModelAndView modelAndView=new ModelAndView("dashboard");
        ModelAndView error=new ModelAndView("error");

        if(status==true) {

            modelAndView.addObject("topiclist",topicDao.getSubscribedTopics(userDTO));


            User sessionUser=(User)request.getSession().getAttribute("userDTO");
            modelAndView.addObject("username",sessionUser.getFirstName());

            return modelAndView;
        }
        else
            return error;


    }

}
