package com.gedev.game.android.object;

public abstract class ObjectBase {
    private String name;

    public ObjectBase(String name){
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
