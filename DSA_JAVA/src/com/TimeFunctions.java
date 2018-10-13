package com;
import java.lang.System;
public class TimeFunctions {
    long starTime;
    long endTime;

    public long getStarTime() {
        return starTime;
    }

    public void setStarTime() {
        this.starTime = System.nanoTime();
    }


    public long getEndTime() {
        return endTime;
    }

    public void setEndTime() {
        this.endTime = System.nanoTime();
    }

    public long timeDifference () {
        return endTime-starTime;
    }
}