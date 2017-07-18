package com.service;

import com.dao.TopicDaoImpl;
import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.utils.HibernateUtil;
import com.utils.enums.Seriousness;
import com.utils.enums.Visibility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.Date;

/**
 * Created by Shreya on 7/18/2017.
 */
public class SubscriptionServiceImpl {

    TopicDaoImpl topicDao=new TopicDaoImpl();
    public boolean saveSubscription(int topicId, User user, Seriousness seriousness){
        boolean status=false;
        Topic topic=topicDao.getTopicById(topicId);
        Subscription newsub=new Subscription();

        Session session= HibernateUtil.openSession();
        Transaction transaction = null;
        Topic newTopic=new Topic();
        try {
            transaction = session.getTransaction();
            transaction.begin();

            //newUser = new User(user.getEmail(),user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),new Date(),new Date());
            //newTopic=new Topic(topic.getName(),user,new Date(),new Date(),visible);
            newsub=new Subscription(topic,user,seriousness, new Date());
            session.save(newsub);
            transaction.commit();
            status=true;
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
