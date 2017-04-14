package com.nick.controllers;

import com.nick.service.XOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {
    private XOInterface xoInterface;

//    @Autowired(required = true)
//    @Qualifier(value = "xoInterface")
    public void setXoInterface(XOInterface xoInterface) {
        this.xoInterface = xoInterface;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(){
        return "main";
    }

    @RequestMapping(value = "/push/{id}")
    public String push(@PathVariable("id") int id){
        this.xoInterface.pushX();
        return "sk";
    }
}
