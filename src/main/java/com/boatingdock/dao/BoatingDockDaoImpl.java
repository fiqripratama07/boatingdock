package com.boatingdock.dao;

import com.boatingdock.constant.MessageConstant;
import com.boatingdock.model.Boat;

import java.util.HashMap;
import java.util.Map;

public class BoatingDockDaoImpl implements BoatingDockDao {

    private Map<Integer, Boat> Boats = new HashMap<>();
    private Integer capacity;

    public BoatingDockDaoImpl(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String createBoatingDock() {
        for (int pearsNumber = 1; pearsNumber <= this.capacity ; pearsNumber++) {
            Boats.put(pearsNumber,null);
        }
        return String.format(MessageConstant.CREATE_BOATING_DOCK,this.capacity);
    }
}
