package com.risker.managecenter.serviceprovider;

import com.risker.manageshared.model.User;
import com.risker.manageshared.service.IUserWriteService;

/**
 * Created by myz on 16/8/25.
 * 写服务
 * 1.单笔操作不加事务,多笔操作加上事务
 * 2.可以在写服务的方法中同事更新缓存
 */
public class UserWriteServiceImpl implements IUserWriteService {
    @Override
    public Integer insert(User user) {
        return null;
    }

    @Override
    public Integer update(User user) {
        return null;
    }
}
