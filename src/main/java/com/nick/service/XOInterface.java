package com.nick.service;


import java.util.ArrayList;
import java.util.HashMap;

public interface XOInterface {
    void pushX(int idCell, int idGame);
    void pushO(int idCell, int idGame);
    void fillMap();
    boolean checkExists(int id, int idGame);
    boolean win(ArrayList<Integer> list);
    String winPresice(int id);
    int countMap(int idGame);
    HashMap<Integer, String> model(int idGame);
    HashMap<Integer,HashMap<Integer,String>> listModels();
    HashMap<Integer,HashMap<Integer,String>> createNewGame();
    HashMap<Integer,String> getActualGame(int id);
}
