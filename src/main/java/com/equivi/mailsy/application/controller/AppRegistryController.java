package com.equivi.mailsy.application.controller;

import com.equivi.mailsy.application.service.AppRegistryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AppRegistryController {

    @Autowired
    private AppRegistryService appRegistryService;

    @RequestMapping(value = "/validateApp")
    @ResponseBody
    public String checkRegistryKey(@RequestParam(name = "registeredKey") String registeredKey) {
        return String.valueOf(appRegistryService.isApplicationExpired(registeredKey));
    }
}
