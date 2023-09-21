package ru.marten.teacherapplication;

public class CounterHolder {

    private int counterValue = 0;

    private static CounterHolder instance;

    private CounterHolder() {

    }

    public static synchronized CounterHolder getInstance() {
        if (instance == null) {
            instance = new CounterHolder();
        }
        return instance;
    }

    public void increment() {
        this.counterValue++;
    }

    public int getCounterValue() {
        return counterValue;
    }
}
