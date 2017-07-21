package com.dao;

import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.utils.HibernateUtil;
import com.utils.enums.Visibility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.jws.soap.SOAPBinding;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;

import static com.utils.enums.Visibility.PUBLIC;

/**
 * Created by Shreya on 7/18/2017.
 */
@Component
public class TopicDaoImpl {

    public int saveTopic(Topic topic,User user){
       // boolean status=false;
        int topicId=0;
        Session session= HibernateUtil.openSession();
        Transaction transaction = null;
        Topic newTopic=new Topic();
        try {
            transaction = session.getTransaction();
            transaction.begin();
            Visibility visible=topic.getVisibility();

            System.out.println("v"+visible);
            //newUser = new User(user.getEmail(),user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),new Date(),new Date());
            newTopic=new Topic(topic.getName(),user,new Date(),new Date(),visible);
            session.save(newTopic);
            transaction.commit();
            topicId=newTopic.getTopicId();
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return topicId;
    }

    public Topic getTopicById(Integer topicId){
        Session session = HibernateUtil.openSession();
        System.out.println("here");
        Topic topic = null;
        Query query = session.createQuery("from Topic where topicId=:id");
        query.setParameter("id",topicId);
        topic = (Topic) query.uniqueResult();
        System.out.println("topic obj"+topic.toString());
        return topic;
    }

    public Topic getTopicByName(String topicName){
        Session session = HibernateUtil.openSession();
        System.out.println("here");
        Topic topic = null;
        Query query = session.createQuery("from Topic where name=:name");
        query.setParameter("name",topicName);
        topic = (Topic) query.uniqueResult();
        System.out.println("topic obj"+topic.toString());
        return topic;
    }

    //working fine
    public List getSubscribedTopics(User user){
        List<Topic> list;
        String username=user.getUsername();
        Session session=HibernateUtil.openSession();
        Query query=session.createQuery("from Topic where createdBy='"+username+"' order by dateCreated desc ");
        list=query.list();
        return list;
    }

    public Integer topicCount(HttpServletRequest request ){
        Session session=HibernateUtil.openSession();
        User currentUser=(User)request.getSession().getAttribute("userDTO");
        Query query=session.createQuery("select count(*) from Topic where createdBy='"+currentUser.getUsername()+"'");
        Integer count=((Number) query.uniqueResult()).intValue();
        System.out.println(count);
        return count;
    }

    public List getPublicTopics(){
        List<Topic> list;
        Session session=HibernateUtil.openSession();
        Query query=session.createQuery("from Topic where visibility='PUBLIC' order by lastUpdated desc ");
        list=query.list();
        return list;
    }

    public List getCreatedTopicsList(HttpServletRequest request) {
        Session session = HibernateUtil.openSession();
        User currentUser = (User) request.getSession().getAttribute("userDTO");
        Query query = session.createQuery("from Topic where createdBy='" + currentUser.getUsername() + "'");
        List<Topic> topicList = query.list();
        return topicList;
    }


    public boolean deleteTopicAndResource(HttpServletRequest request,Integer topicId) {
        boolean status=false;
        int result=0;
        int resourceResult=0;
        Session session=HibernateUtil.openSession();
        Transaction transaction=null;

        try {
            transaction=session.getTransaction();
            transaction.begin();
            Query resourceQuery=session.createQuery("delete from Resource where topic.topicId=:id");
            resourceQuery.setParameter("id",topicId);
            resourceResult=resourceQuery.executeUpdate();

            status=true;

         /*   if(resourceResult==1){
                Query query=session.createQuery("delete FROM Topic where topicId=:id");
                query.setParameter("id",topicId);
                result=query.executeUpdate();
                transaction.commit();
                status=true;
            }*/
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return status;
    }

    public boolean editTopic(Integer topicId,String topicName) {
        boolean status=false;
        int result=0;
        Session session=HibernateUtil.openSession();
        Transaction transaction=null;
        try {
            transaction=session.getTransaction();
            transaction.begin();
            Query query=session.createQuery("update Topic set name=:tname where topicId=:id");
            query.setParameter("tname",topicName);
            query.setParameter("id",topicId);
            result=query.executeUpdate();
            transaction.commit();
            status=true;
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return status;
    }

    public List<Topic> getTopicList(String topicName) {
        List<Topic> topicList;
        Session session=HibernateUtil.openSession();
        Query query=session.createQuery("from Topic where name=:name");
        query.setParameter("name",topicName);
        topicList=query.list();
        return topicList;
    }
}

