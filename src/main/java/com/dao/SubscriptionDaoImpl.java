package com.dao;

import com.model.Subscription;
import com.model.Topic;
import com.model.User;
import com.utils.HibernateUtil;
import com.utils.enums.Seriousness;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by Shreya on 7/18/2017.
 */
@Component
public class SubscriptionDaoImpl {

    public boolean saveSubscription(Topic topic, User user, Seriousness seriousness){
        Subscription newsub=new Subscription();
        boolean status=false;
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
