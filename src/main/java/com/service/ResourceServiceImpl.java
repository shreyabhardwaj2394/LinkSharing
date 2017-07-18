package com.service;

import com.model.LinkResource;
import com.model.Resource;

import java.util.Date;

/**
 * Created by Shreya on 7/18/2017.
 */
public class ResourceServiceImpl {

    UserServiceImpl userService=new UserServiceImpl();
    TopicServiceImpl topicService=new TopicServiceImpl();

    public int saveLinkResource(Resource linkResourceDTO){
        int id = 0;
        System.out.println("des"+linkResourceDTO.getDescription());
       /* if (linkResourceDTO != null) {
            Resource linkResource = new LinkResource(linkResourceDTO.getDescription(),
                    userService.getUser(linkResourceDTO.getCreatedBy()),
                    topicService.getTopic(linkResourceDTO.getTopicId()), new Date(), new Date(),
                    linkResourceDTO.getUrl());
            id = resourceDAO.saveResource(linkResource);
        }*/
        return id;
    }
}
