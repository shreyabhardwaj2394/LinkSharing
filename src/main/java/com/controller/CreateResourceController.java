package com.controller;

import com.model.Resource;
import com.model.User;
import com.service.ResourceServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Shreya on 7/18/2017.
 */
@Controller
public class CreateResourceController {

    ResourceServiceImpl resourceService=new ResourceServiceImpl();

    @RequestMapping(value = "/createLinkResource", method = RequestMethod.POST)
    public ModelAndView createLinkResource(@ModelAttribute Resource linkResourceDTO, HttpServletRequest request,
                                           HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("userDTO");
        //linkResourceDTO.setCreatedBy(userDTO);
        int id = resourceService.saveLinkResource(linkResourceDTO);
        ModelAndView modelAndView=new ModelAndView("dashboard");
        return modelAndView;
    }
}
