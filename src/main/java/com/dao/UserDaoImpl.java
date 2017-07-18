package com.dao;

import com.utils.HibernateUtil;
import com.model.User;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.List;

/**
 * Created by Shreya on 7/11/2017.
 */
public class UserDaoImpl implements UserDao {
    @Override
    public int register(User user) {
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
            newUser = new User(user.getEmail(),user.getUsername(), user.getPassword(), user.getFirstName(), user.getLastName(),new Date(),new Date());
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
        Transaction transacion = null;
        User user = null;
        try {
            transacion = session.getTransaction();
            transacion.begin();
            Query query = session.createQuery("from User where username='"+username+"'");
            user = (User)query.uniqueResult();
            transacion.commit();
        } catch (Exception e) {
            if (transacion != null) {
                transacion.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }


    public boolean authenticateUser(String username, String password, HttpServletRequest request, HttpServletResponse response) {
        User user = getUserByUserName(username,password);
        User newUser;
        if(user!=null && user.getUsername().equals(username) && user.getPassword().equals(password)){
            newUser=findUser(username);
            request.getSession().setAttribute("userDTO",user);
            return true;
        }else{
            return false;
        }
    }


    public User getUserByUserName(String username,String password) {
        Session session = HibernateUtil.openSession();
        Transaction transacion = null;
        User user = null;
        try {
            transacion = session.getTransaction();
            transacion.begin();
            Query query = session.createQuery("from User where username='"+username+"' and password='"+password+"'");
            user = (User)query.uniqueResult();
            transacion.commit();
        } catch (Exception e) {
            if (transacion != null) {
                transacion.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }
        return user;
    }


    public boolean authenticateEmail(String email) {
        User user = emailCheck(email);
        if(user!=null && user.getEmail().equals(email)){
            return true;
        }else{
            return false;
        }
    }

    public User emailCheck(String email){
        Session session=HibernateUtil.openSession();
        Transaction transaction=null;
        User user=null;
        try {
            transaction=session.getTransaction();
            transaction.begin();
            Query query=session.createQuery("from User where email='"+email+"'");
            user=(User)query.uniqueResult();
            System.out.println(user);
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        return user;

    }

    public boolean changePassword(String email,String password){
        boolean status=false;
        int result=0;
        Session session=HibernateUtil.openSession();
        Transaction transaction=null;
        User user=null;
        try {
            transaction=session.getTransaction();
            transaction.begin();
            Query query=session.createQuery("update User set password='"+password+"' where email='"+email+"'");
            result=query.executeUpdate();
            transaction.commit();
        }catch (Exception e) {
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            session.close();
        }

        if(result==1)
            status=true;
        else
            status=false;

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
