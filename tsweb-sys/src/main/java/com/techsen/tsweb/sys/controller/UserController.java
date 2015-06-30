package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;

@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private UserService userService;
    
    @RequestMapping("/{userId}")
    public String info(@PathVariable String userId, Model modal) {
        User user = this.userService.getById(userId);
        modal.addAttribute("user", user);
        return "/sys/user-info";
    }
    
}
