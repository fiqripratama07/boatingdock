package com.boatingdock;

import com.boatingdock.dao.BoatingDockDaoImpl;
import com.boatingdock.model.Boat;

public class MainApp {

    public static void main(String[] args) {
        Boat boat1 = new Boat("KA-01-HH-1234","White");
        Boat boat2 = new Boat("KA-01-HH-9999","White");
        Boat boat3 = new Boat("KA-01-BB-0001","Black");
        Boat boat4 = new Boat("KA-01-HH-7777","Red");
        Boat boat5 = new Boat("KA-01-HH-2701","Blue");
        Boat boat6 = new Boat("KA-01-HH-3141","Black");
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(6);
        System.out.println(boatingDockDao.createBoatingDock());
        System.out.println(boatingDockDao.dock(boat1));
        System.out.println(boatingDockDao.dock(boat2));
        System.out.println(boatingDockDao.dock(boat3));
        System.out.println(boatingDockDao.dock(boat4));
        System.out.println(boatingDockDao.dock(boat5));
        System.out.println(boatingDockDao.dock(boat6));
        System.out.println(boatingDockDao.leave(4));
        System.out.println(boatingDockDao.status());

    }
}
