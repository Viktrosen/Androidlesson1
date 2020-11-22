package com.hfrad.android_lesson_1;

public final class MainPresenter {
    private static MainPresenter instance = null;
    private static final Object syncObj = new Object();
    private int temperature;

    private MainPresenter(){
        temperature = 0;
    }

    public int getTemperature(){
        return temperature;
    }

    public static MainPresenter getInstance(){
        synchronized (syncObj) {
            if (instance == null) {
                instance = new MainPresenter();
            }
            return instance;
        }
    }
}
