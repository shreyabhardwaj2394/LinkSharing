package com.dao;

import com.model.User;
import com.utils.HibernateUtil;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * Created by Shreya on 7/19/2017.
 */
@Component
public class UniqueEmailDaoImpl implements UniqueEmailDao{
    @Override
    public boolean checkavailability(String email) {
        Session session= HibernateUtil.openSession();

        System.out.println("email final:"+email);
        //Criteria criteria=session.createCriteria(User.class);
        List<User> list;

        Query query=session.createQuery("from User where email='"+email+"'");
        list=query.list();

        return !list.isEmpty();
    }
}
