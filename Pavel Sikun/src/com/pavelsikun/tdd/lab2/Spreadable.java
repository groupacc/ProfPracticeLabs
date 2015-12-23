package com.pavelsikun.tdd.lab2;

/**
 * Created by mrbimc on 23.12.15.
 */
public interface Spreadable extends Comparable<Spreadable>{
    int getSpread();

    @Override
    default int compareTo(Spreadable o) {
        return getSpread() - o.getSpread();
    }
}
