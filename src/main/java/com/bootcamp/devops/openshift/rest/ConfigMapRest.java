package com.bootcamp.devops.openshift.rest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConfigMapRest {

    @RequestMapping(method = RequestMethod.GET, value = "variable")
    public String getVariable(@RequestParam String secret) {
        return System.getenv(secret);
    }

}
