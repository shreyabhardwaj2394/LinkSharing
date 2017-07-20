package com.utils.enums;

/**
 * Created by Shreya on 7/18/2017.
 */

public enum Seriousness {

    CASUAL(0), SERIOUS(1), VERY_SERIOUS(2);

    private final int seriousness;

    Seriousness(int seriousness) {
        this.seriousness = seriousness;
    }

    int getSeriousness() {
        return this.seriousness;
    }

}