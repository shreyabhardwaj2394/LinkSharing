package com.dao;

import com.utils.HibernateUtil;
import com.model.User;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Shreya on 7/11/2017.
 */
@Component
public class UserDaoImpl implements UserDao {
    @Override
    public int register(User user,byte[] photo) {
        int registered=0;
        System.out.println(user.getEmail());
        System.out.println(user.getFirstName());
        /*SimpleDateFormat sdf = new SimpleDateFormat("dd/M/yyyy");
        String date = sdf.format(new Date());*/


        Session session=HibernateUtil.openSession();
        Transaction transaction = null;
        User newUser=null;
        try {
            transaction = session.getTransaction();
            transaction.begin();
            newUser = new User(user.getEmail(),user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),new Date(),new Date(),photo,true);
            session.save(newUser);

            transaction.commit();
            registered = 1;
        }catch (Exception e){
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        }
        finally {
            session.close();
        }

        return registered;
    }

    @Override
    public void update(User user) {

    }

    @Override
    public void delete(User user) {

    }

    @Override
    public User findUser(String username) {
        Session session = HibernateUtil.openSession();
        User user = null;
            Query query = session.createQuery("from User where username='"+username+"'");
            user = (User)query.uniqueResult();
        return user;
    }



    public boolean authenticateUser(String uservariable, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = getUserByUserName(uservariable,password);
        User newUser;
        if(user!=null && user.getPassword().equals(password)){
            newUser=findUser(uservariable);
            if(newUser==null){
                newUser=emailCheck(uservariable);
            }
            request.getSession().setAttribute("userDTO",newUser);
            newUser.setActive(true);
            return true;
        }else{
            return false;
        }
    }


    public User getUserByUserName(String uservariable,String password) {
        Session session = HibernateUtil.openSession();
        User user = null;
            Query query = session.createQuery("from User where username='"+uservariable+"'");
            user = (User)query.uniqueResult();
            if(user==null){
                Query queryEmail=session.createQuery("from User where email='"+uservariable+"'");
                user = (User)queryEmail.uniqueResult();
            }
        return user;
    }


    public boolean authenticateEmail(String email) {
        User user = emailCheck(email);
        return user != null && user.getEmail().equals(email);
    }

    public User emailCheck(String email){
        Session session=HibernateUtil.openSession();

        User user=null;
            Query query=session.createQuery("from User where email='"+email+"'");
            user=(User)query.uniqueResult();
            System.out.println(user);
        return user;

    }

    public boolean changePassword(String email,String password){
        boolean status=false;
        int result=0;
        Session session=HibernateUtil.openSession();
        Transaction transaction=null;
        try {
            transaction=session.getTransaction();
            transaction.begin();
            Query query=session.createQuery("update User set password='"+password+"' where email='"+email+"'");
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

    public boolean updateDetails(User user, byte[] photo,HttpServletRequest request) {
        User sessionUser=(User)request.getSession().getAttribute("userDTO");
        String username=sessionUser.getUsername();
        boolean status=false;
        int result=0;
        Session session=HibernateUtil.openSession();
        Transaction transaction=null;

        try {
            transaction=session.getTransaction();
            transaction.begin();
            Query query=session.createQuery("update User set firstName='"+user.getFirstName()+"', lastName='"+user.getLastName()+"',photo='"+photo+"'  where username='"+username+"'");
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


   /* private User getUser(String username) {
        DetachedCriteria criteria = DetachedCriteria.forClass(User.class);
        criteria.add(Restrictions.eq("username", username));
        List<?> list = getHibernateTemplate().findByCriteria(criteria);

        User user = null;
        if (!list.isEmpty()) {
            user = (User) list.get(0);
        }
        return user;
    }

    public User getUser(String username, String password) {

        User user = getUser(username);
        if (user != null && !user.getPassword().equals(password)) {
            user = null;
        }
        return user;
    }*/

}
