package com.techsen.tsweb.sys.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.techsen.tsweb.sys.domain.Menu;
import com.techsen.tsweb.sys.service.MenuService;

@Controller
@RequestMapping("/")
public class SysController {

    @Resource
    private MenuService menuService;
    
    @RequestMapping("/sys")
    public String sys(Model model) {
        
        Menu brandMenu = this.menuService.getBrandMenu();
        model.addAttribute("brandMenu", brandMenu);
        
        Menu rootMenu = this.menuService.getMenuByPath("/qareport");
        model.addAttribute("rootMenu", rootMenu);
        
        return "/sys/main";
    }
    
}
