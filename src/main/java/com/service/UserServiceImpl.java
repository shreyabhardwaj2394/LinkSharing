package com.service;

import com.dao.UserDaoImpl;
import com.model.User;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;


/**
 * Created by Shreya on 7/11/2017.
 */
@Service
public class UserServiceImpl implements UserService{

    UserDaoImpl userDao=new UserDaoImpl();
    //Register Method
    public void register(User user){
        System.out.println(user.getFirstName());
        System.out.println(user.getLastName());

        int check=userDao.register(user);
        if(check==1) {
            System.out.println("Registered");
            ApplicationContext context = new ClassPathXmlApplicationContext("Spring-Mail.xml");
            String FirstName=user.getFirstName();
            String email=user.getEmail();
            String subject="Link Sharing Registration";
            String message="You have been Registered with LinkSharing!";
            MailSendingService mail = (MailSendingService) context.getBean("mailMail");
            mail.sendMail(email,subject,message);

        }
        else
            System.out.println("Not Registered");
    }

    //Login Method
    public boolean login(User user){
        String username=user.getUsername();
        String password=user.getPassword();
        return (userDao.authenticateUser(username,password));
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

}