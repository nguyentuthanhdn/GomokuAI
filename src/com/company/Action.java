package com.company;

public abstract class Action {
    public abstract void createThreatDiagonal();
    public abstract void createVerticalDiagonal();
    public abstract void createHorizontalDiagonal();

    public abstract void blockThreat();
    public Action() {

    }
    public abstract void getAction();

}
