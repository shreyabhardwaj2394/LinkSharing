package com.service;

import com.dao.ResourceDaoImpl;
import com.model.LinkResource;
import com.model.Resource;
import com.model.User;

import java.util.Date;

/**
 * Created by Shreya on 7/18/2017.
 */
public class ResourceServiceImpl {

    UserServiceImpl userService=new UserServiceImpl();

    TopicServiceImpl topicService=new TopicServiceImpl();

    ResourceDaoImpl resourceDao=new ResourceDaoImpl();

    public boolean saveLinkResource(LinkResource linkResourceDTO,User user){
        boolean status=false;
        System.out.println("des"+linkResourceDTO.getDescription());
       if (linkResourceDTO != null) {
            LinkResource linkResource = new LinkResource(linkResourceDTO.getDescription(),
                    user, topicService.getTopic(linkResourceDTO.getTopic()), new Date(), new Date(),
                    linkResourceDTO.getUrl());
            status = resourceDao.saveResource(linkResource);
        }
        return status;
    }
}
