package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.techsen.tsweb.sys.domain.User;
import com.techsen.tsweb.sys.service.UserService;
import com.techsen.tsweb.sys.util.JsonResult;

@Controller
@RequestMapping("/sys/user")
public class UserController {

    @Resource
    private UserService userService;
    
    @RequestMapping("/{userId}")
    public String view(@PathVariable String userId, Model model) {
        User user = this.userService.getById(userId);
        model.addAttribute("user", user);
        return "/sys/user-view";
    }
    
    @RequestMapping(value="/update/{userId}", method=RequestMethod.GET)
    public String update(@PathVariable String userId, Model model) {
        User user = this.userService.getById(userId);
        model.addAttribute("user", user);
        return "/sys/user-update";
    }
    
    @ResponseBody
    @RequestMapping(value="/update/{userId}", method=RequestMethod.POST)
    public JsonResult update(@PathVariable String userId, User user) {
        
        System.out.println();
        System.out.println("------------------");
        try {
            this.userService.updateEntity(user);
        } catch(Exception e) {
            e.printStackTrace();
        }
        System.out.println("------------------");
        System.out.println();
        
        return new JsonResult(user);
    }
}
