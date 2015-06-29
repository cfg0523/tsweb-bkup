package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.MenuService;

@Controller
@RequestMapping("/")
public class NavController {

    @Resource
    private MenuService menuService;
    
    @RequestMapping("/")
    public String nav(Model model) {
        Menu brandMenu = this.menuService.getBrandMenu();
        model.addAttribute("brandMenu", brandMenu);
        model.addAttribute("rootMenu", this.menuService.getMenuByPath("/qareport"));
        return "/sys/main";
    }
    
    @RequestMapping("/{module}")
    public String nav(@PathVariable String module, Model model) {
        Menu rootMenu = this.menuService.getMenuByPath("/" + module);
        model.addAttribute("rootMenu", rootMenu);
        return "/sys/aside";
    }
    
}
