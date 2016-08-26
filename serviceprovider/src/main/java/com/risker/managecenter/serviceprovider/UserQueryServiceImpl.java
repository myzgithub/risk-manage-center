package com.risker.managecenter.serviceprovider;

import com.risker.managecenter.dao.IUserQueryDao;
import com.risker.manageshared.model.User;
import com.risker.manageshared.service.IUserQueryService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by myz on 16/8/25.
 * 开发过程中修改了shared之后再本地打包之前先删除掉原来本地maven仓库中的jar
 * 然后install,再到center中reimport一下。
 *
 * 1.一般不直接查询数据库,而是先查询缓存
 * 2.不加事务
 */
public class UserQueryServiceImpl implements IUserQueryService{

    @Autowired
    private IUserQueryDao userQueryDao;

    @Override
    public List<User> queryAll() {

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

        List<User> userList = new ArrayList<User>();
        userList.add(user);
        userList.add(user2);

        return userList;

//        return userQueryDao.queryAll();//我的linux不能访问外网和mac本机  在本机测试没问题,部署到linux中会有问题的
    }
}
