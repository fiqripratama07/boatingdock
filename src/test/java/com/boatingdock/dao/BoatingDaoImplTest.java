package com.boatingdock.dao;

import com.boatingdock.constant.MessageConstant;
import com.boatingdock.model.Boat;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BoatingDaoImplTest {


    @Test
    public void createBoatingDock_shouldReturnMessageCreateBoatingDock(){
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(6);
        Integer expectedCapaity = 6;
        String expectedString = String.format(MessageConstant.CREATE_BOATING_DOCK,expectedCapaity);
        String actualString = boatingDockDao.createBoatingDock();
        assertEquals(expectedString,actualString);
    }

    @Test
    public void dock_ShouldReturnMessageBoatingDockFull_whenBoatingDockIsFull() {
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(1);
        boatingDockDao.createBoatingDock();
        Boat firstBoat = new Boat("KA-01-HH-1234","White");
        Boat secondBoat = new Boat("KA-01-HH-9999","White");
        boatingDockDao.dock(firstBoat);
        String expectedString = MessageConstant.BOATING_DOCK_FULL;
        String actualString = boatingDockDao.dock(secondBoat);
        assertEquals(expectedString,actualString);
    }

    @Test
    public void dock_ShouldReturnMessageDockFailed_whenBoatIsExist() {
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(2);
        boatingDockDao.createBoatingDock();
        Boat firstBoat = new Boat("KA-01-HH-1234","White");
        Boat secondBoat = new Boat("KA-01-HH-1234","White");
        boatingDockDao.dock(firstBoat);
        String expectedString = MessageConstant.DOCK_FAILED;
        String actualString = boatingDockDao.dock(secondBoat);
        assertEquals(expectedString,actualString);
    }

    @Test
    public void dock_shouldReturnMessageDockSucces_whenBoatingDockIsExist(){
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(1);
        boatingDockDao.createBoatingDock();
        Boat firstBoat = new Boat("KA-01-HH-1234","White");
        Integer expectedPiersNumber = 1;
        String expectedString = String.format(MessageConstant.DOCK_SUCCESS,expectedPiersNumber);
        String actualString = boatingDockDao.dock(firstBoat);
        assertEquals(expectedString,actualString);
    }

    @Test
    public void leave_shouldReturnMessageLeaveFailed_whenBoatIsNotExist(){
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(1);
        boatingDockDao.createBoatingDock();
        Integer expectedPierNumber = 1;
        String expectedString =MessageConstant.LEAVE_FAILED;
        String actualString = boatingDockDao.leave(1);
        assertEquals(expectedString,actualString);

    }

    @Test
    public void leave_shouldReturnMessageLeaveSuccess_whenBoatingDock_andDockIsExist(){
        BoatingDockDaoImpl boatingDockDao = new BoatingDockDaoImpl(1);
        boatingDockDao.createBoatingDock();
        Boat firstBoat = new Boat("KA-01-HH-1234","White");
        boatingDockDao.dock(firstBoat);
        Integer expectedPierNumber = 1;
        String expectedString = String.format(MessageConstant.LEAVE_SUCCESS,expectedPierNumber);
        String actualString = boatingDockDao.leave(1);
        assertEquals(expectedString,actualString);
    }
}
