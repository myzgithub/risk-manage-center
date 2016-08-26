package com.risker.managecenter.web.contorllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by myz on 16/8/14.
 */
@RestController
@RequestMapping(value = "okcontorller")
public class OkContorller {

    @RequestMapping(value = "/ok")
    public String test(){

        return "ok";
    }
}
