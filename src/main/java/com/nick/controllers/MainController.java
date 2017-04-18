package com.nick.controllers;

import com.nick.service.XOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Controller
public class MainController {

    private XOInterface xoInterface;

    @Autowired(required = true)
    @Qualifier(value = "xoInterface")
    public void setXoInterface(XOInterface xoInterface) {
        this.xoInterface = xoInterface;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model, HttpServletRequest request, HttpServletResponse response, HttpSession session){
        if (xoInterface.model().isEmpty()){
            xoInterface.fillMap();
        }
        if (xoInterface.countMap() > 4) {
            if (xoInterface.win("x")) {
                model.addAttribute("xWin", "X Win!");
            }else if (xoInterface.win("o")) {
                model.addAttribute("oWin", "O Win!");
            }else if (xoInterface.countMap()==9){
                model.addAttribute("bothLosers", "You are both losers!");
            }
        }

        model.addAttribute("list", xoInterface.model());
        return "main";
    }

    @RequestMapping(value = "/push/{id}", method = RequestMethod.GET)
    public String push(@PathVariable("id") int id, Model model, HttpServletRequest request, HttpServletResponse responsee){
        if (xoInterface.win("x")||xoInterface.win("o")){
            model.addAttribute("list", xoInterface.model());
            return "main";
        }
        if (!xoInterface.checkExists(id)) {
            if (xoInterface.countMap() % 2 == 0) {
                xoInterface.pushX(id);
            } else {
                xoInterface.pushO(id);
            }

        }else {
            model.addAttribute("duplicate", "already exists!");
        }
//        model.addAttribute("list", xoInterface.model());
//        System.out.println(xoInterface.model().toString());
        return "redirect:/";
    }

    @RequestMapping(value = "/restart")
    public String restart(){
        xoInterface.fillMap();
        return "redirect:/";
    }
}
