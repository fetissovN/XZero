package com.nick.controllers;

import com.nick.service.XOImpl;
import com.nick.service.XOInterface;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

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

    @RequestMapping(value = "/push/{id}", method = RequestMethod.GET)
    public ModelAndView push(@PathVariable("id") int id){
        XOImpl xo = new XOImpl();
        ModelAndView modelAndView = new ModelAndView();
        if (xo.model().size()%2==1){
            xo.pushX(id);
            modelAndView.addObject("x"+ id,"X");
            modelAndView.setViewName("main");
        }else {
            xo.pushO(id);
            modelAndView.addObject("x"+ id,"O");
            modelAndView.setViewName("main");
        }
        System.out.println(xo.model().toString());
        return modelAndView;
    }
}
