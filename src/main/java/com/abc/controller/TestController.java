package com.abc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TestController {
	
    @GetMapping("/signup")
    public String Test() {
        return "test";
    }
}
