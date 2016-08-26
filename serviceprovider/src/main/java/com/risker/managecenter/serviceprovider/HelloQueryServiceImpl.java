package com.risker.managecenter.serviceprovider;

import com.risker.manageshared.service.IHelloQueryService;
import org.springframework.stereotype.Service;

/**
 * Created by myz on 16/8/15.
 * 如何才能使用注解的方式?
 */
public class HelloQueryServiceImpl implements IHelloQueryService{
    @Override
    public String sayHello(String name){

        return "hello"+name;
    }

}
