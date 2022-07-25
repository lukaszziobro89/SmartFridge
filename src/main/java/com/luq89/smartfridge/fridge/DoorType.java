package com.luq89.smartfridge.fridge;

import com.fasterxml.jackson.annotation.JsonValue;

public enum DoorType {

    SIDE_BY_SIDE("Side by Side"),
    TOP_FREEZER("Top freezer"),
    BOTTOM_FREEZER("Bottom freezer"),
    FRENCH_DOOR("French door");

    @JsonValue
    private final String displayName;

    DoorType(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return this.displayName;
    }
}
