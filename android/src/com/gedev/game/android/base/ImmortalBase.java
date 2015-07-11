package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 03/7/2015.
 */
public abstract class ImmortalBase extends ObjectBase {

    private Vector2 geometry;

    public ImmortalBase(String name, float x, float y) {
        super(name);
        geometry = new Vector2(x, y);
    }

    public ImmortalBase(String name, Vector2 geometry) {
        super(name);
        this.geometry = geometry;
    }

    public Vector2 getGeometry() {
        return geometry;
    }

    public void setGeometry(float x, float y) {
        this.geometry.set(x, y);
    }

    public void setGeometry(Vector2 geometry) {
        this.geometry = geometry;
    }

}
