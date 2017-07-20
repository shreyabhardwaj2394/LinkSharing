package com.dao;

import com.model.DocumentResource;
import com.model.LinkResource;
import com.model.Resource;
import com.model.Topic;
import com.utils.HibernateUtil;
import com.utils.enums.Visibility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Shreya on 7/19/2017.
 */
@Component
public class ResourceDaoImpl {
    public boolean saveResource(LinkResource resource){
        boolean status=false;
        Session session= HibernateUtil.openSession();
        Transaction transaction = null;
        LinkResource newResource=new LinkResource();
        try {
            transaction = session.getTransaction();
            transaction.begin();
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

    public List getResourceByTopic(String topicName){
        Session session=HibernateUtil.openSession();
        List<Resource> resourceList;
        Query query=session.createQuery("from Resource where topic.name='"+topicName+"'");
        resourceList=query.list();
        return resourceList;
    }


    public List getPubic(){
        List<Resource> resourceList;
        Session session=HibernateUtil.openSession();
        Query query=session.createQuery("from Resource where topic.visibility='PUBLIC' order by dateCreated desc ");
        resourceList=query.setMaxResults(5).list();
        return resourceList;
    }
}
