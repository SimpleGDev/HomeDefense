package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 6/20/2015.
 */
public abstract class MortalMovementBase extends MortalBase {

    private float speed;

    public MortalMovementBase(String name, float x, float y, int healthPoint, float speed) {
        super(name, x, y, healthPoint);
        this.speed = speed;
    }

    public MortalMovementBase(String name, Vector2 geometry, int healthPoint, float speed) {
        super(name, geometry, healthPoint);
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
