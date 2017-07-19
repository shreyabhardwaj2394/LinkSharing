package com.dao;

import com.model.DocumentResource;
import com.model.LinkResource;
import com.model.Resource;
import com.model.Topic;
import com.utils.HibernateUtil;
import com.utils.enums.Visibility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by Shreya on 7/19/2017.
 */
public class ResourceDaoImpl {
    public boolean saveResource(LinkResource resource){
        boolean status=false;
        Session session= HibernateUtil.openSession();
        Transaction transaction = null;
        LinkResource newResource=new LinkResource();
        try {
            transaction = session.getTransaction();
            transaction.begin();
            //newUser = new User(user.getEmail(),user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),new Date(),new Date());
            // newTopic=new Topic(topic.getName(),user,new Date(),new Date(),visible);

            newResource=new LinkResource(resource.getDescription(),resource.getCreatedBy(),resource.getTopic(),new Date(),new Date(),resource.getUrl());
            session.save(newResource);
            transaction.commit();
            status=true;
            //topicId=newTopic.getTopicId();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return status;
    }


    public boolean saveResource(DocumentResource resource){
        boolean status=false;
        Session session= HibernateUtil.openSession();
        Transaction transaction = null;
        DocumentResource newResource=new DocumentResource();
        try {
            transaction = session.getTransaction();
            transaction.begin();
            //newUser = new User(user.getEmail(),user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),new Date(),new Date());
            // newTopic=new Topic(topic.getName(),user,new Date(),new Date(),visible);

            newResource=new DocumentResource(resource.getDescription(),resource.getCreatedBy(),resource.getTopic(),new Date(),new Date(),resource.getFilePath());
            session.save(newResource);
            transaction.commit();
            status=true;
            //topicId=newTopic.getTopicId();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return status;
    }
}
