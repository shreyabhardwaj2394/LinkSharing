package com.service;

import com.dao.UserDaoImpl;
import com.model.User;
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
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());
        String username=user.getUsername();
        User newUser;
        int check=userDao.register(user,photo);
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
        try{
            HttpSession session=request.getSession(false);
            if(session!=null)
                session.invalidate();
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

   /* public User getUser(User userDTO) {
        return userDao.getUser(userDTO.getUsername(), userDTO.getPassword());
    }*/

}
