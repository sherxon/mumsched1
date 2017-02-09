package uz.mumsched.controllers;

import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;


/**
 * Created by sherxon on 1/25/17.
 */
@Controller
public class IndexController implements ErrorController{


    @RequestMapping(value = "/error")
    public String error() {
        return "Error handling";
    }

    @Override
    public String getErrorPath() {
        return "/error";
    }

    @RequestMapping(value = "/login")
    public ModelAndView login(){
        return new ModelAndView("login");
    }

    @RequestMapping(value = "/admin")
    @PreAuthorize(value = "ADMIN")
    public ModelAndView indexAdmin(){
        return new ModelAndView("index");
    }

    @RequestMapping(value = "/student")
    public ModelAndView indexUser(){
        return new ModelAndView("student/index");
    }

    @RequestMapping(value = "/")
    public ModelAndView index(HttpServletRequest request){
        if(request.isUserInRole("ADMIN"))
            return new ModelAndView("redirect:/admin");
        else
            return new ModelAndView("redirect:/student");
    }
}
