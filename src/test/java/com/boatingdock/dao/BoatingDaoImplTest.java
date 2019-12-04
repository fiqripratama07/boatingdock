package com.boatingdock.dao;

import com.boatingdock.constant.MessageConstant;
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
}
