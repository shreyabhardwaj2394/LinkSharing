package com.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * Created by Shreya on 7/21/2017.
 */
@Controller
public class SubscribeTopicController {
  /*  @RequestMapping(value = "/subscribeTopic")
    public ModelAndView subscribeTopic(@RequestParam(value = "topicId", required = true) Integer topicId,
                                       @RequestParam(value = "seriousness", required = true) Seriousness seriousness, HttpServletRequest request,
                                       HttpServletResponse response) {
        logger.trace("Inside subscribeTopic method");
        UserDTO userDTO = (UserDTO) request.getSession().getAttribute("userDTO");
        if (userDTO != null) {
            int id = subscriptionService.saveSubscription(topicId, userDTO, seriousness);
            if (id == 0) {
                logger.warn("Topic not subscribed!");
            } else {
                logger.info("Topic subscribed");
            }
        }
        return getView(request);
    }*/
}
