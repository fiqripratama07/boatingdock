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
                    boats.put(pearsNumber, boat);
                    return String.format(MessageConstant.DOCK_SUCCESS, pearsNumber);
                }
                return MessageConstant.DOCK_FAILED;
            }
        }
        return MessageConstant.BOATING_DOCK_FULL;
    }

    @Override
    public String leave(Integer pierNumber) {
        if (boats.get(pierNumber) != null) {
            boats.put(pierNumber, null);
            return String.format(MessageConstant.LEAVE_SUCCESS, pierNumber);
        }
        return MessageConstant.LEAVE_FAILED;
    }

    @Override
    public String getStatus() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(MessageConstant.STATUS);
        Integer pierNumber;
        String registrationNumber;
        String colour;
        for (Map.Entry<Integer, Boat> boatEntry : boats.entrySet()) {
            try {
                pierNumber = boatEntry.getKey();
                registrationNumber = boatEntry.getValue().getRegistrationNumber();
                colour = boatEntry.getValue().getColour();
                stringBuilder.append(String.format(MessageConstant.CONTENT_STATUS, pierNumber, registrationNumber, colour));
            } catch (Exception e) {
            }
        }
        return stringBuilder.toString();
    }

    @Override
    public String findRegNumberByColour(String colour) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer,Boat> boatEntry : boats.entrySet()){
            if (boatEntry.getValue().getColour().equals(colour)){
                stringBuilder.append(String.format(MessageConstant.FIND_REGNUMBER_BY_COLOUR,boatEntry.getValue().getRegistrationNumber()));
            }
        }
        stringBuilder.replace(stringBuilder.lastIndexOf(","),stringBuilder.lastIndexOf(",") + 1,"");
        return stringBuilder.toString();
    }

    @Override
    public String findSlotNumberByColour(String colour) {
        StringBuilder stringBuilder = new StringBuilder();
        for (Map.Entry<Integer,Boat> boatEntry : boats.entrySet()){
            if (boatEntry.getValue().getColour().equals(colour)){
                stringBuilder.append(String.format(MessageConstant.FIND_SLOTNUMBER_BY_COLOUR,boatEntry.getKey()));
            }
        }
        stringBuilder.replace(stringBuilder.lastIndexOf(","),stringBuilder.lastIndexOf(",") + 1,"");
        return stringBuilder.toString();
    }
}
