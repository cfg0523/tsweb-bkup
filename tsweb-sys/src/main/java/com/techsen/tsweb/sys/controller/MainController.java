package com.techsen.tsweb.sys.controller;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.auth.annotation.AuthComponent;
import com.techsen.tsweb.sys.auth.annotation.AuthOperation;

@Controller
@RequestMapping("/sys")
@AuthComponent(resourceType = "sys", name = "main")
public class MainController {

    @RequestMapping("/main")
    @AuthOperation(aclPos = 3)
    @RequiresPermissions("sys:main:main")
    public String main() {
        return "/sys/main";
    }

}
