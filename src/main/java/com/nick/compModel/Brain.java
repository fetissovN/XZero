package com.nick.compModel;

import com.nick.service.XOImpl;
import com.nick.service.XOInterface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Random;

@Component
public class Brain {
    @Autowired
    private XOInterface xoInterface;
    public void easyPush(int idGame){
        HashSet<Integer> list = new HashSet<>();
        Random random = new Random();
        for (int i=0;i<9;i++){
            list.add(random.nextInt(9));
        }

        for (Integer i: list){
            if (!xoInterface.checkExists(i, idGame)) {
                if (xoInterface.countMap(idGame) % 2 == 0) {
                    xoInterface.pushX(i,idGame);
                    return;
                } else {
                    xoInterface.pushO(i,idGame);
                    return;
                }

            }
        }
    }
}
