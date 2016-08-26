package com.risker.managecenter.web.contorllers;

import com.risker.manageshared.model.User;
import com.risker.manageshared.service.IUserQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * Created by myz on 16/8/25.
 */
@RestController
@RequestMapping("/usercontorller")
public class UserController {

    private Logger logger = LoggerFactory.getLogger(UserController.class);

    @Autowired
    private IUserQueryService userQueryService;

    @RequestMapping("/list")
    public ModelAndView queryLs(Model model){
        logger.info("user list entry...");
        List<User> userList = userQueryService.queryAll();
        model.addAttribute("userList",userList);
        return new ModelAndView("/userlist");
    }
}
