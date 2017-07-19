package com.dao;

/**
 * Created by Shreya on 7/19/2017.
 */

        import com.model.User;
        import com.utils.HibernateUtil;
        import org.hibernate.Criteria;
        import org.hibernate.Query;
        import org.hibernate.Session;
        import org.hibernate.SessionFactory;
        import org.hibernate.criterion.Restrictions;
        import org.springframework.beans.factory.annotation.Autowired;
        import org.springframework.stereotype.Component;

        import java.util.List;

/**
 * Created by user on 7/3/2017.
 */
@Component
public class UniqueusernameDaoImpl implements UniqueusernameDao  {


    public boolean checkavailability(String username) {
        Session session= HibernateUtil.openSession();

        System.out.println("username final:"+username);
        //Criteria ct=ss.createCriteria(User.class);
        List<User> list;

        Query query=session.createQuery("from User where username='"+username+"'");
        list=query.list();

        if(list.isEmpty())
        {
            return false;
        }
        else
        {
            return true;
        }
    }
}