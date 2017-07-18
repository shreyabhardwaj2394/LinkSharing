package com.controller;

import com.dao.TopicDaoImpl;
import com.model.LinkResource;
import com.model.Resource;
import com.model.Topic;
import com.model.User;
import com.service.ResourceServiceImpl;
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

        System.out.println("des"+linkResourceDTO.getDescription());
        boolean status = resourceService.saveLinkResource(linkResourceDTO,user,topicvalue);

        ModelAndView modelAndView=new ModelAndView("dashboard");
        ModelAndView error=new ModelAndView("error");

        if(status==true)
            return modelAndView;
        else
            return error;
    }
}
