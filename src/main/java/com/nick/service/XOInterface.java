package com.nick.service;


import java.util.HashMap;

public interface XOInterface {
    public void pushX(int id);
    public void pushO(int id);
    public HashMap<Integer, String> model();
}
