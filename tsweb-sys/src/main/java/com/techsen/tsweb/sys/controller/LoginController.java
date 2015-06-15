package com.techsen.tsweb.sys.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.techsen.tsweb.sys.domain.User;

@Controller
@RequestMapping("/sys")
public class LoginController {
    
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(boolean error) {
        if (error) {
            System.out.println("登录失败");
        }
        return "/sys/login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(User user) {
        if (user != null) {
            UsernamePasswordToken token = new UsernamePasswordToken(
                    user.getUsername(), user.getPassword());
            token.setRememberMe(true);
            Subject subject = SecurityUtils.getSubject();
            subject.login(token);
        }
        return "redirect:/sys/main";
    }

    @RequestMapping(value = "/logout")
    public String logout() {
        Subject subject = SecurityUtils.getSubject();
        if (subject.isAuthenticated()) {
            subject.logout();
        }
        return "redirect:/sys/login";
    }
}
