package ru.jucharick;

import java.util.List;

public class Fork {
    private volatile boolean isUsed;

    public boolean isUsedFork() {
        return isUsed;
    }

    public void setUsedFork(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
