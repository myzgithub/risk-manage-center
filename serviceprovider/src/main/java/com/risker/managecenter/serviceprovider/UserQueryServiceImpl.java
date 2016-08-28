package com.risker.managecenter.serviceprovider;

import com.risker.allshared.enums.ResultCodeEnum;
import com.risker.allshared.model.ResultModel;
import com.risker.managecenter.dao.IUserQueryDao;
import com.risker.manageshared.model.User;
import com.risker.manageshared.service.IUserQueryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by myz on 16/8/25.
 * 开发过程中【修改了shared等公共依赖】先删除掉原来本地maven仓库中的jar,在执行install
 * 同样git更新代码的时候删除本地仓库的公共依赖的jar 然后在install一下 ---没办法啊没有私服现在
 * 然后install,再到center等调用方中reimport一下。
 *
 * 1.一般不直接查询数据库,而是先查询缓存
 * 2.不加事务
 */
public class UserQueryServiceImpl implements IUserQueryService{

    private Logger LOGGER = LoggerFactory.getLogger(UserQueryServiceImpl.class);

    @Autowired
    private IUserQueryDao userQueryDao;

    /**
     * @author myz
     * 标准写法可以参考如下这样
     * @return
     */
    @Override
    public ResultModel<List<User>> queryAll() {
        ResultModel<List<User>> resultModel = null;

        try{
            resultModel = new ResultModel<List<User>>();

            User user = new User();
            user.setAge(12);
            user.setName("张三啊啊模拟数据");
            user.setBirth(new Date());
            user.setId(1);

            User user2 = new User();
            user2.setAge(22);
            user2.setName("lisi啊模拟数据");
            user2.setBirth(new Date());
            user2.setId(2);

            List<User> userList = new ArrayList<User>();//userQueryDao.queryAll();
            userList.add(user);
            userList.add(user2);

            resultModel.setModel(userList);

        }catch (Exception e){
            resultModel.setCode(ResultCodeEnum.EXCEPTION);
            resultModel.setMessage("查询用户列表异常");
            LOGGER.error("UserQueryService Exception",e);
            return resultModel;
        }
        return resultModel;

//        return userQueryDao.queryAll();//我的linux不能访问外网和mac本机  在本机测试没问题,部署到linux中会有问题的
    }
}
