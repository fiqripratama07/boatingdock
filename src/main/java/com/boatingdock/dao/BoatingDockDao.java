package com.boatingdock.dao;

import com.boatingdock.model.Boat;

public interface BoatingDockDao {

    public String createBoatingDock();
    public String dock(Boat boat);
}
