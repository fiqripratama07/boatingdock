package com.boatingdock.utils;

import com.boatingdock.constant.InputConstant;
import com.boatingdock.dao.BoatingDockDaoImpl;
import com.boatingdock.model.Boat;

import java.io.BufferedReader;
import java.io.IOException;

public class BoatingDockInputProcessorImpl implements BoatingDockInputProcessor {

    BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(6);


    @Override
    public String process(BufferedReader bufferedReader) throws IOException {
        String scan;
        String colour;
        String regNumber;
        StringBuilder stringBuilder = new StringBuilder();
        while ((scan = bufferedReader.readLine()) != null) {
            String[] data = scan.trim().split("\\s");
            for (int read = 0; read < data.length; read++) {
                if (data == null) {
                    break;
                } else {
                    switch (data[read]) {
                        case InputConstant.CREATE_BOATING_DOCK:
                            Integer capacity = Integer.parseInt(data[read + 1]);
                            boatingDockDao = new BoatingDockDaoImpl(capacity);
                            stringBuilder.append(boatingDockDao.createBoatingDock());
                            break;
                        case InputConstant.DOCK:
                            regNumber = data[read + 1];
                            colour = data[read + 2];
                            Boat boat = new Boat(regNumber, colour);
                            stringBuilder.append(boatingDockDao.dock(boat));
                            break;
                        case InputConstant.LEAVE:
                            Integer slotNumber = Integer.parseInt(data[read + 1]);
                            stringBuilder.append(boatingDockDao.leave(slotNumber));
                            break;
                        case InputConstant.STATUS:
                            stringBuilder.append(boatingDockDao.getStatus());
                            break;
                        case InputConstant.FIND_REGNUMBER_BY_COLOUR:
                            colour = data[read + 1];
                            stringBuilder.append(boatingDockDao.findRegNumberByColour(colour) + "\n");
                            break;
                        case InputConstant.FIND_SLOTNUMBER_BY_COLOUR:
                            colour = data[read + 1];
                            stringBuilder.append(boatingDockDao.findSlotNumberByColour(colour) + "\n");
                            break;
                        case InputConstant.FIND_SLOTNUMBER_BY_REGNUMBER:
                            regNumber = data[read + 1];
                            stringBuilder.append(boatingDockDao.findSlotNumberByRegistrationNumber(regNumber));
                            break;
                    }
                }
            }
        }
        return stringBuilder.toString();
    }
}
