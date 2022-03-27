package com.rayhan.alpc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@SpringBootApplication
public class AlpcApplication {

    public static void main(String[] args) {
        SpringApplication.run(AlpcApplication.class, args);
    }

    @RequestMapping("/regis")
    public ModelAndView home() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("Regis");
        return modelAndView;
    }

}
