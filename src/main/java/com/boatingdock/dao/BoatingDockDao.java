package com.boatingdock.dao;

import com.boatingdock.model.Boat;

public interface BoatingDockDao {

    public String createBoatingDock();
    public String dock(Boat boat);
    public String leave(Integer pierNumber);
    public String getStatus();
    public String findRegNumberByColour(String colour);
    public String findSlotNumberByColour(String colour);
}
