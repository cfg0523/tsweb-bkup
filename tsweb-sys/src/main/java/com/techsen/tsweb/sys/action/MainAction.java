package com.techsen.tsweb.sys.action;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/sys")
public class MainAction {

    @RequestMapping("/main")
    public String main() {
        return "/sys/main";
    }
    
}
