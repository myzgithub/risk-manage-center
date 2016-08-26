package com.risker.managecenter.dao;

import com.risker.manageshared.model.User;

import java.util.List;

/**
 * Created by myz on 16/8/25.
 */
public interface IUserQueryDao {

    public List<User> queryAll();
}
