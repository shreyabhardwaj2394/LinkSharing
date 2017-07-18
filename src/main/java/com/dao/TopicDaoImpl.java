package com.dao;

import com.model.Topic;
import com.model.User;
import com.utils.HibernateUtil;
import com.utils.enums.Visibility;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.jws.soap.SOAPBinding;
import javax.persistence.criteria.CriteriaBuilder;
import java.util.Date;
import java.util.List;

/**
 * Created by Shreya on 7/18/2017.
 */
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
        Transaction transacion = null;
        Topic topic = null;
        try {
            transacion = session.getTransaction();
            transacion.begin();
            Query query = session.createQuery("from Topic where topicId='"+topicId+"'");
            topic = (Topic) query.uniqueResult();
            transacion.commit();
        } catch (Exception e) {
            if (transacion != null) {
                transacion.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return topic;

    }

    public List getSubscribedTopics(User user){
        List<Topic> list;
        Session session=HibernateUtil.openSession();
        Query query=session.createQuery("from Topic order by dateCreated desc");
        list=query.list();
        return list;
    }
}
