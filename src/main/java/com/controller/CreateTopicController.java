/*
package com.controller;

import com.model.Topic;
import com.model.User;
import com.utils.enums.Seriousness;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

*/
/**
 * Created by Shreya on 7/18/2017.
 *//*

@Controller
public class CreateTopicController {
    @RequestMapping(value = "/createTopic", method = RequestMethod.POST)
    public ModelAndView createTopic(@ModelAttribute Topic topic, HttpServletRequest request,
                                    HttpServletResponse response) {
        User user = (User) request.getSession().getAttribute("userDTO");
        topic.setCreatedBy(user);
        int id = topicService.saveTopic(topicDTO);
        if (id == 0) {
            logger.warn("Topic not saved!");
        } else {

            subscribeTopic(id, Seriousness.VERY_SERIOUS, request, response);
        }
        return getView(request);
    }
}
*/
