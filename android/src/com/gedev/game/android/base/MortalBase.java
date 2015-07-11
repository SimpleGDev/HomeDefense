package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 */
public abstract class MortalBase extends ObjectBase {

    private Vector2 geometry;
    private int healthPoint;

    public MortalBase(String name, float x, float y, int healthPoint) {
        super(name);
        geometry = new Vector2(x, y);
        this.healthPoint = healthPoint;
    }

    public MortalBase(String name, Vector2 geometry, int healthPoint) {
        super(name);
        this.geometry = geometry;
        this.healthPoint = healthPoint;
    }

    public Vector2 getGeometry() {
        return geometry;
    }

    public int getHealthPoint() {
        return healthPoint;
    }

    public void setGeometry(float x, float y) {
        geometry.set(x, y);
    }

    public void setGeometry(Vector2 geometry) {
        this.geometry = geometry;
    }

    public void setHealthPoint(int healthPoint) {
        this.healthPoint = healthPoint;
    }

}
