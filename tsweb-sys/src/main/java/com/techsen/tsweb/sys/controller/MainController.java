package com.techsen.tsweb.sys.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.annotation.AuthComponent;
import com.techsen.tsweb.sys.annotation.AuthOperation;

@Controller
@RequestMapping("/sys")
@AuthComponent(desc = "主页控制器")
public class MainController {

    @RequestMapping("/main")
    @AuthOperation(aclBit = 0x01, desc = "跳转到主页")
    public String main() {
        return "/sys/main";
    }

}
