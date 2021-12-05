package com.example.budgetmanager;


public class GoalObject {
    double value;
    double saved;
    String goalDesc;

    public  GoalObject(String _title, double _value) {
        this.value = _value;
        this.goalDesc = _title;
        this.saved = 0;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setSaved(double saved) {
        this.saved = this.saved+ saved;
    }

    public double getValue() {
        return value;
    }

    public double getSaved() {
        return saved;
    }

    public String getGoalDesc() {
        return goalDesc;
    }
}
