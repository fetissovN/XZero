package com.nick.controllers;

import com.nick.service.XOImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @Autowired
    private XOImpl xo;

// TODO: 15.04.2017 try this below
//    private XOInterface xoInterface;

//    @Autowired(required = true)
//    @Qualifier(value = "xoInterface")
//    public void setXoInterface(XOInterface xoInterface) {
//        this.xoInterface = xoInterface;
//    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public ModelAndView main(){
        if (xo.model().isEmpty()){
            xo.fillMap();
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("main");
        modelAndView.addObject("list", xo.model());
        return modelAndView;
    }

    @RequestMapping(value = "/push/{id}", method = RequestMethod.GET)
    public ModelAndView push(@PathVariable("id") int id){
        ModelAndView modelAndView = new ModelAndView();
        if (xo.countMap()%2==0){
            xo.pushX(id);
            modelAndView.addObject("list",xo.model());
            modelAndView.setViewName("main");
        }else {
            xo.pushO(id);
            modelAndView.addObject("list",xo.model());
            modelAndView.setViewName("main");
        }
        System.out.println(xo.model().toString());
        return modelAndView;
    }

    @RequestMapping(value = "/restart")
    public ModelAndView restart(){
        ModelAndView modelAndView = new ModelAndView();
        xo.fillMap();
        modelAndView.addObject("list",xo.model());
        modelAndView.setViewName("main");
        return modelAndView;
    }
}
