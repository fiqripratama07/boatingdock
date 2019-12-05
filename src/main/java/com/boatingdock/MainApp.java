package com.boatingdock;


import com.boatingdock.constant.InputConstant;
import com.boatingdock.dao.BoatingDockDaoImpl;
import com.boatingdock.model.Boat;
import com.boatingdock.utils.BoatingDockInputProcessorImpl;

import java.io.*;
import java.util.Scanner;

public class MainApp {

    private static BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(6);

    public static void main(String[] args) throws IOException {
        if (args.length > 0) {
            try {
                File file = new File(args[0]);
                BufferedReader r;
                r = new BufferedReader(new FileReader(file));
                BoatingDockInputProcessorImpl dockInputProcessor = new BoatingDockInputProcessorImpl();
                System.out.println(dockInputProcessor.process(r));
            } catch (Exception e) {

            }
        } else {
            inputCommandProcess();
        }
    }

    private static void inputCommandProcess() {
        try {
            while (true) {
                String colour;
                String regNumber;
                Scanner scanner = new Scanner(System.in);
                System.out.println("Input Command");
                System.out.println("$ ");
                String input = scanner.nextLine();
                String[] command = input.trim().split("\\s");
                switch (command[0]) {
                    case InputConstant.CREATE_BOATING_DOCK:
                        Integer capacity = Integer.parseInt(command[1]);
                        boatingDockDao = new BoatingDockDaoImpl(capacity);
                        System.out.println(boatingDockDao.createBoatingDock());
                        break;
                    case InputConstant.DOCK:
                        regNumber = command[1];
                        colour = command[2];
                        Boat boat = new Boat(regNumber, colour);
                        System.out.println(boatingDockDao.dock(boat));
                        break;
                    case InputConstant.LEAVE:
                        Integer slotNumber = Integer.parseInt(command[1]);
                        System.out.println(boatingDockDao.leave(slotNumber));
                        break;
                    case InputConstant.STATUS:
                        System.out.println(boatingDockDao.getStatus());
                        break;
                    case InputConstant.FIND_REGNUMBER_BY_COLOUR:
                        colour = command[1];
                        System.out.println(boatingDockDao.findRegNumberByColour(colour) + "\n");
                        break;
                    case InputConstant.FIND_SLOTNUMBER_BY_COLOUR:
                        colour = command[1];
                        System.out.println(boatingDockDao.findSlotNumberByColour(colour) + "\n");
                        break;
                    case InputConstant.FIND_SLOTNUMBER_BY_REGNUMBER:
                        regNumber = command[1];
                        System.out.println(boatingDockDao.findSlotNumberByRegistrationNumber(regNumber));
                        break;
                }
            }
        } catch (Exception e) {

        }
    }
}