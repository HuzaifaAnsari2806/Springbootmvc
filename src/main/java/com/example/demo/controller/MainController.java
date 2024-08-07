package com.example.demo.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class MainController {

    @GetMapping("home")
    public String home(HttpServletRequest req) {
    	HttpSession session=req.getSession();
    	String name=req.getParameter("name");
    	session.setAttribute("name", name);
        System.out.println("Hello world");
        return "home"; 
    }
    
    @GetMapping("new")
    public String newhome(@RequestParam("name") String myName,HttpSession session) {
    	session.setAttribute("name", myName);
    	return "home";
    }
    
    @GetMapping("newhome")
    public ModelAndView example(String name) {
    	ModelAndView modelAndView=new ModelAndView();
    	modelAndView.addObject("name", name);
    	modelAndView.setViewName("home");
    	return modelAndView;
    }
    
    
    @GetMapping("nohome")
    public ModelAndView anotherexample(Alien alien) {
    	ModelAndView modelAndView=new ModelAndView();
    	modelAndView.addObject("obj", alien);
    	modelAndView.setViewName("hello");
    	return modelAndView;
    }
    
    
}
