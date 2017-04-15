package com.nick.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

@Component
public class XOImpl implements XOInterface {
    ArrayList<Integer> modelX = new ArrayList<Integer>();
    ArrayList<Integer> modelO = new ArrayList<Integer>();
    HashMap<Integer,String> mapList = new HashMap<Integer, String>();

    public void fillMap(){
        for (int i=0;i<9;i++){
            mapList.put(i,"");
        }
    }

    public boolean win(){
        boolean win = false;
        
        return win;
    }

    public int countMap(){
        int count=0;
        for (Map.Entry<Integer,String> map: mapList.entrySet()){
            if (map.getValue()!=""){
                count++;
            }
        }
        return count;
    }
    @Override
    public void pushX(int id) {
        mapList.put(id,"X");
//     modelX.add(id);
    }

    @Override
    public void pushO(int id) {
        mapList.put(id,"O");
//        modelO.add(id);
    }

    @Override
    public HashMap<Integer, String> model() {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.addAll(modelX);
//        list.addAll(modelO);
        return mapList;
    }

}
