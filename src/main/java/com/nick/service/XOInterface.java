package com.nick.service;


import java.util.HashMap;

public interface XOInterface {
    void pushX(int id);
    void pushO(int id);
    void fillMap();
    boolean checkExists(int id);
    boolean win(String playerChar);
    int countMap();
    HashMap<Integer, String> model();
}
