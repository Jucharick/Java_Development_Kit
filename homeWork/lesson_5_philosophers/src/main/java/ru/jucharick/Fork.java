package ru.jucharick;

public class Fork {
    //region Fields
    private volatile boolean isUsed;
    //endregion

    //region Public Methods
    public Fork (boolean isUsed) {
        this.isUsed = isUsed;
    }

    public boolean isUsedFork() {
        return isUsed;
    }

    public void setUsedFork(boolean isUsed) {
        this.isUsed = isUsed;
    }
    //endregion
}
