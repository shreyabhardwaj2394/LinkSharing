package com.service;

import com.dao.ResourceDaoImpl;
import com.model.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.URL;
import java.util.Date;

/**
 * Created by Shreya on 7/18/2017.
 */
public class ResourceServiceImpl {

    UserServiceImpl userService=new UserServiceImpl();

    TopicServiceImpl topicService=new TopicServiceImpl();

    ResourceDaoImpl resourceDao=new ResourceDaoImpl();

    public boolean saveLinkResource(LinkResource linkResourceDTO,User user,Integer topicvalue){
        boolean status=false;
        System.out.println("des"+linkResourceDTO.getDescription());
        Topic topic=topicService.getTopic(topicvalue);
       if (linkResourceDTO != null) {
            LinkResource linkResource = new LinkResource(linkResourceDTO.getDescription(),
                    user, topic, new Date(), new Date(),
                    linkResourceDTO.getUrl());
            status = resourceDao.saveResource(linkResource);
        }
        return status;
    }

    public boolean saveDocumentResource(DocumentResource documentResourceDTO, MultipartFile file,Integer topicValue,User user) {

        boolean status=false;
        try {
            /*String webPath = context.getRealPath("/");
            System.out.println(webPath);*/
            byte[] bytes=file.getBytes();

            File file2 = new File("C:/Users/Shreya/Desktop/LinkSharingFinal/LinkSharing/src/main/webapp/Topics/"+file.getOriginalFilename());
            BufferedOutputStream stream=new BufferedOutputStream(
                    new FileOutputStream(file2)
            );
            stream.write(bytes);
            stream.close();
            System.out.println(file2);

            Topic topic=topicService.getTopic(topicValue);

           DocumentResource documentResource = new DocumentResource(documentResourceDTO.getDescription(),
                    user,
                    topic, new Date(), new Date(),
                   "C:/Users/Shreya/Desktop/LinkSharingFinal/LinkSharing/src/main/webapp/Topics/"+file.getOriginalFilename() );

            status= resourceDao.saveResource(documentResource);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
        return status;
    }
}
