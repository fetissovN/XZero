package com.nick.controllers;

import com.nick.compModel.Brain;
import com.nick.service.XOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.servlet.http.HttpSession;
import java.util.*;

@Controller
public class MainController {


    @Autowired
    private Brain brain;

    private XOInterface xoInterface;

    @Autowired(required = true)
    @Qualifier(value = "xoInterface")
    public void setXoInterface(XOInterface xoInterface) {
        this.xoInterface = xoInterface;
    }

    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String main(Model model, HttpSession session){

        HashMap<Integer,HashMap<Integer,String>> modelS = new HashMap<>();
        if (session.getAttribute("game")==null){
            modelS = xoInterface.createNewGame();
            session.setAttribute("game", modelS);
        }else {
            modelS.putAll((Map<? extends Integer, ? extends HashMap<Integer, String>>) session.getAttribute("game"));
        }

        int id = modelS.keySet().iterator().next();
        if (xoInterface.countMap(id) > 4) {
            String winner = xoInterface.winPresice(id);
            if (winner.equals("X")) {
                model.addAttribute("xWin", "X Win!");
            }else if (winner.equals("O")) {
                model.addAttribute("oWin", "O Win!");
            }else if (xoInterface.countMap(id)==9){
                model.addAttribute("bothLoseras", "You are both losers!");
            }
        }
        System.out.println(modelS.get(1));
        model.addAttribute("list", modelS.get(1));
        return "main";
    }

    @RequestMapping(value = "/push/{id}", method = RequestMethod.GET)
    public String push(@PathVariable("id") int id, Model model, HttpSession session){

        HashMap<Integer,HashMap<Integer,String>> modelS = new HashMap<>();

        modelS.putAll((Map<? extends Integer, ? extends HashMap<Integer, String>>) session.getAttribute("game"));

        int idGame = modelS.keySet().iterator().next();
        if (!xoInterface.winPresice(idGame).equals("false")){
            model.addAttribute("list", modelS.get(1));
            return "main";
        }
        if (!xoInterface.checkExists(id, idGame)) {
            if (xoInterface.countMap(idGame) % 2 == 0) {
                xoInterface.pushX(id,idGame);
            } else {
                xoInterface.pushO(id,idGame);
            }

        }else {
            model.addAttribute("duplicate", "already exists!");
            model.addAttribute("list",modelS.get(1));
            return "main";
        }
        return "redirect:/";
    }

    @RequestMapping(value = "/restart")
    public String restart(HttpSession session){
        HashMap<Integer,HashMap<Integer,String>> modelS = new HashMap<>();

        modelS.putAll((Map<? extends Integer, ? extends HashMap<Integer, String>>) session.getAttribute("game"));

        int idGame = ((Map<? extends Integer, ? extends HashMap<Integer,String>>) session.getAttribute("game")).entrySet().iterator().next().getKey();
        System.out.println(idGame);
        xoInterface.resetGame(idGame);
        return "redirect:/";
    }

    @RequestMapping(value = "/compTurn")
    public String compTurn(Model model, HttpSession session){
        HashMap<Integer,HashMap<Integer,String>> modelS = new HashMap<>();

        modelS.putAll((Map<? extends Integer, ? extends HashMap<Integer, String>>) session.getAttribute("game"));

        int idGame = ((Map<? extends Integer, ? extends HashMap<Integer,String>>) session.getAttribute("game")).entrySet().iterator().next().getKey();
        if (!xoInterface.winPresice(idGame).equals("false")){
            model.addAttribute("list", modelS.get(1));
            return "main";
        }
        brain.easyPush(idGame);

        return "redirect:/";
    }




}
