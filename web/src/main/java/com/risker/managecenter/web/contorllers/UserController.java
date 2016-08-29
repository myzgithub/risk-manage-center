package com.risker.managecenter.web.contorllers;

import com.risker.allshared.enums.ResultCodeEnum;
import com.risker.allshared.model.ResultModel;
import com.risker.allshared.model.paging.PagingResultModel;
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
        try{
            PagingResultModel<User> userListModel = userQueryService.queryAll();

            if(userListModel!=null && userListModel.getCode() == ResultCodeEnum.SUCCESS && userListModel.getModel()!=null){
                List<User> userList = userListModel.getModel();
                model.addAttribute("userList", userList);
            }
        }catch (Exception e){
            logger.error("用户列表查询服务异常",e);
            throw new RuntimeException("异常。。。。",e);//如果自己捕捉了异常,不跳转到错误页面,那么这里要求你在抛出去--我后期会加上统一错误页面
        }

        return new ModelAndView("/userlist");
    }
}
