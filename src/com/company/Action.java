package com.company;

public abstract class Action {
    public abstract void createThreatDiagonal();
    public abstract void createVerticalDiagonal();
    public abstract void createHorizontalDiagonal();
    public abstract void blockThreat();
    public abstract void completeThreat();
    private double action;
    public Action() {
    }
    public abstract void getAction(double action);

    public void actionEstimate() {

    }
}
