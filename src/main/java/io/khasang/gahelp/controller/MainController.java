package io.khasang.gahelp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

    @RequestMapping("/")
    public String getStat(){
        return "welcome";
    }

    @RequestMapping("/wel")
    public String getWel(){
        return "wel";
    }
}
