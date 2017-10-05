package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by UA C on 04.10.2017.
 */
@Controller
public class MainPageController {
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String getIndexPage(Model model) {
        return "index";
    }
}
