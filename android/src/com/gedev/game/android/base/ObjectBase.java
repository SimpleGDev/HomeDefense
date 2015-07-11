package com.gedev.game.android.base;

/**
 * Created by Kraisorn Rakam on 03/7/2015.
 */
public abstract class ObjectBase {

    private String name;

    public ObjectBase(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}
