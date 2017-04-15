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
        ArrayList<Integer> mass = new ArrayList<Integer>();
        mass.add(1);
        mass.add(3);
        mass.add(4);
        for (Integer m: mass){
            if (modelX.contains(1+m)&&modelX.contains(1+m+m)){
                win=true;
            }
        }
        for (Integer m: mass){
            if (modelX.contains(5+m)&&modelX.contains(5-m)){
                win=true;
            }
        }
        for (Integer m: mass){
            if (modelX.contains(9-m)&&modelX.contains(9-m-m)){
                win=true;
            }
        }

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
        modelX.add(id);
    }

    @Override
    public void pushO(int id) {
        mapList.put(id,"O");
        modelO.add(id);
    }

    @Override
    public HashMap<Integer, String> model() {
//        ArrayList<Integer> list = new ArrayList<Integer>();
//        list.addAll(modelX);
//        list.addAll(modelO);
        return mapList;
    }

}
