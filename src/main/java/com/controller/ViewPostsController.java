package com.controller;

import com.model.Resource;
import com.model.User;
import com.service.ResourceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by Shreya on 7/21/2017.
 */

@Controller
public class ViewPostsController {
    ResourceServiceImpl resourceService=new ResourceServiceImpl();

    @RequestMapping(value = "/viewPosts/{resourceId}",method = RequestMethod.GET)
    public ModelAndView view(@PathVariable Integer resourceId, HttpServletRequest request){
        System.out.println("res::"+resourceId);
        ModelAndView resource=new ModelAndView("viewpost");
        ModelAndView error=new ModelAndView("error");
        User sessionUser=(User)request.getSession().getAttribute("userDTO");
        resource.addObject("username",sessionUser.getUsername());
        resource.addObject("first",sessionUser.getFirstName());
        Resource newResource=resourceService.getResourceById(resourceId);
        resource.addObject("resoucre",newResource);

        return resource;
    }
}
