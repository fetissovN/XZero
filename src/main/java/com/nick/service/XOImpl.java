package com.nick.service;

import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class XOImpl implements XOInterface {
    ArrayList<Integer> modelX = new ArrayList<Integer>();
    ArrayList<Integer> modelO = new ArrayList<Integer>();

    @Override
    public void pushX(int id) {
        modelX.add(id);
    }

    @Override
    public void pushO(int id) {
        modelO.add(id);
    }

    @Override
    public ArrayList<Integer> model() {
        ArrayList<Integer> list = new ArrayList<Integer>();
        list.addAll(modelX);
        list.addAll(modelO);
        return list;
    }
}
