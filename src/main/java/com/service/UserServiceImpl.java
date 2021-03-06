package com.service;

import com.dao.UserDaoImpl;
import com.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Created by Shreya on 7/11/2017.
 */
@Service
public class UserServiceImpl{


    UserDaoImpl userDao=new UserDaoImpl();
    //Register Method
    public void register(User user, HttpServletRequest request, HttpServletResponse response,byte[] photo){
        String username=user.getUsername();
        User newUser;
        int check=0;
        if(user.getFirstName()!=null && user.getLastName()!=null && user.getUsername()!=null && user.getEmail()!=null && user.getPassword()!=null)
            check=userDao.register(user,photo);
        if(check==1) {
            System.out.println("Registered");
            ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");

            String email=user.getEmail();
            String subject="Link Sharing Registration";
            String message="You have been Registered with LinkSharing!";
            MailSendingService mail = (MailSendingService) context.getBean("mailMail");
            mail.sendMail(email,subject,message);


            newUser=userDao.findUser(username);
            HttpSession session=request.getSession();
            session.setAttribute("userDTO",newUser);
        }
        else
            System.out.println("Not Registered");
    }

    //Login Method
    public boolean login(User user,HttpServletRequest request,HttpServletResponse response){
        String username=user.getUsername();
        String password=user.getPassword();
        return (userDao.authenticateUser(username,password,request,response));
    }

    //Logout
    public void logout(HttpServletRequest request,HttpServletResponse response){
        User user=(User)request.getSession().getAttribute("userDTO");
        try{

            HttpSession session=request.getSession(false);
            if(session!=null) {
                user.setActive(false);
                session.invalidate();
            }
        }catch (Exception e){
            System.out.println(e);
        }
    }

    //Checking if email exists in db or not
    public boolean emailCheck(User user){
        String email=user.getEmail();
        return (userDao.authenticateEmail(email));
    }

    //Change Password
    public boolean passwordChange(User user){
        String email=user.getEmail();
        String password=user.getPassword();
        boolean status=emailCheck(user);
        if (status==true)
            return (userDao.changePassword(email,password));
        else
            return false;
    }

    public boolean updatePassword(String password,HttpServletRequest request){
        boolean status=false;
        User user=(User)request.getSession().getAttribute("userDTO");
        String email=user.getEmail();
        status=userDao.changePassword(email,password);
        return status;
    }

    public boolean updateDetails(User user, byte[] photo,HttpServletRequest request) {
        boolean status=false;
        status=userDao.updateDetails(user,photo,request);

        return status;
    }

   /* public User getUser(User userDTO) {
        return userDao.getUser(userDTO.getUsername(), userDTO.getPassword());
    }*/

}
