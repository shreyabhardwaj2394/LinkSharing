package com.utils.enums;

/**
 * Created by Shreya on 7/18/2017.
 */
public enum Visibility {

    PUBLIC(1), PRIVATE(0);

    private final int visibility;

    private Visibility(int visibility) {
        this.visibility = visibility;
    }

    int getVisibility() {
        return this.visibility;
    }

}