package com.dao;

import com.model.Topic;
import com.model.User;
import com.utils.HibernateUtil;
import com.utils.enums.Visibility;
import org.hibernate.Session;
import org.hibernate.Transaction;

import javax.jws.soap.SOAPBinding;
import java.util.Date;

/**
 * Created by Shreya on 7/18/2017.
 */
public class TopicDaoImpl {

    public boolean saveTopic(Topic topic,String user){
        boolean status=false;
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
