package com.techsen.tsweb.sys.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.MenuService;

@Controller
@RequestMapping("/sys")
public class MainController {

    @Resource
    private MenuService menuService;
    
    @RequestMapping("/main")
    public String main(Model model) {
        
        List<Menu> navbarTopMenus = this.menuService.getMenusByResourceType("navbar-nav-top");
        model.addAttribute("navbarTopMenus", navbarTopMenus);
        
        return "/sys/main";
    }

}
