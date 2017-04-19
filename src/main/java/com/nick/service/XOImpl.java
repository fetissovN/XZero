package com.nick.service;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Component
public class XOImpl implements XOInterface {

    HashMap<Integer,String> mapList = new HashMap<Integer, String>();
    HashMap<Integer, HashMap<Integer, String>> gamesList = new HashMap<>();

    public HashMap<Integer, HashMap<Integer, String>> createNewGame(){
//        Random random = new Random();
        gamesList.clear();
        HashMap<Integer, HashMap<Integer, String>> map = new HashMap<Integer,HashMap<Integer,String>>();
        int idGame = 1;
            if (gamesList.size()>0) {
            idGame = gamesList.size()+1;
        }
            fillMap();
            gamesList.put(idGame,mapList);
            map.put(idGame,mapList);
        return map;
        }

    @Override
    public HashMap<Integer, String> getActualGame(int id) {
        return null;
    }

    public void resetGame(int idGame){
        gamesList.get(idGame).clear();
        fillMap();
        gamesList.get(idGame).putAll(mapList);
    }

    public void fillMap(){
        mapList.clear();
        for (int i=0;i<9;i++){
            mapList.put(i,"");
        }
//        modelX.clear();
//        modelO.clear();
    }

    public boolean checkExists(int id, int idGame){
        if (!gamesList.get(idGame).get(id).equals("")){
            return true;
        }
        return false;
    }

    public String winPresice(int idGame){
        String winner = null;
        ArrayList<Integer> modelX = new ArrayList<Integer>();
        ArrayList<Integer> modelO = new ArrayList<Integer>();

        HashMap<Integer,String> map = gamesList.get(idGame);
        for (Map.Entry<Integer,String> m: map.entrySet()){
            if (m.getValue().equals("X")){
                modelX.add(m.getKey());
            }else if (m.getValue().equals("O")){
                modelO.add(m.getKey());
            }
        }
        boolean winX = win(modelX);
        boolean winO = win(modelO);
        if (winX){
            winner= "X";
        }
        if (winO){
            winner= "O";
        }

        return winner;
    }

    public boolean win(ArrayList<Integer> listM){
        boolean win = false;
        ArrayList<Integer> list = listM;

        ArrayList<Integer> mass = new ArrayList<Integer>();
        mass.clear();
        mass.add(1);
        mass.add(3);
        mass.add(4);
        for (Integer m: mass){
            if (list.contains(0+m)&&list.contains(0+m+m)&&list.contains(0)){
                win=true;
            }
            if (list.contains(4+m)&&list.contains(4-m)&&list.contains(4)){
                win=true;
            }
            if (list.contains(4)&&list.contains(2)&&list.contains(6)){
                win=true;
            }
            if (list.contains(8-m)&&list.contains(8-m-m)&&list.contains(8)){
                win=true;
            }
        }

        return win;
    }

    public int countMap(int idGame){
        int count=0;
        HashMap<Integer,String> mmm = model(idGame);
        for (Map.Entry<Integer,String> map: mmm.entrySet()){
            if (map.getValue()!=""){
                count++;
            }
        }
        return count;
    }
    @Override
    public void pushX(int idCell, int idGame) {
        gamesList.get(idGame).put(idCell,"X");
    }

    @Override
    public void pushO(int idCell, int idGame) {
        gamesList.get(idGame).put(idCell,"O");
    }

    @Override
    public HashMap<Integer, String> model(int idGame) {
        return gamesList.get(idGame);
    }

    @Override
    public HashMap<Integer, HashMap<Integer, String>> listModels() {
        return gamesList;
    }

}
