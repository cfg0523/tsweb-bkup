package com.techsen.tsweb.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

@Controller
@RequestMapping("/sys")
public class SysController {

    @Resource
    private UserService userService;
    
    @RequestMapping("/user")
    public String user(Model model) {
        List<User> users = this.userService.getAllUsers();
        model.addAttribute("users", users);
        return "/sys/user";
    }
    
}
