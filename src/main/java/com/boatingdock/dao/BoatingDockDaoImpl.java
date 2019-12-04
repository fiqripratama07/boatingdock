package com.boatingdock.dao;

import com.boatingdock.constant.MessageConstant;
import com.boatingdock.model.Boat;

import java.util.HashMap;
import java.util.Map;

public class BoatingDockDaoImpl implements BoatingDockDao {

    private Map<Integer, Boat> boats = new HashMap<>();
    private Integer capacity;

    public BoatingDockDaoImpl(Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String createBoatingDock() {
        for (int pearsNumber = 1; pearsNumber <= this.capacity; pearsNumber++) {
            boats.put(pearsNumber, null);
        }
        return String.format(MessageConstant.CREATE_BOATING_DOCK, this.capacity);
    }

    @Override
    public String dock(Boat boat) {
        for (int pearsNumber = 1; pearsNumber <= this.capacity; pearsNumber++) {
            if (boats.get(pearsNumber) == null) {
                if (!boats.containsValue(boat)) {
                    System.out.println(boats.containsValue(boat));
                    boats.put(pearsNumber, boat);
                    return String.format(MessageConstant.DOCK_SUCCESS, pearsNumber);
                }
                return MessageConstant.DOCK_FAILED;
            }
        }
        return MessageConstant.BOATING_DOCK_FULL;
    }
}
