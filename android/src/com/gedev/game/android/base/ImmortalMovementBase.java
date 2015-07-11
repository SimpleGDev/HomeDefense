package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by dreamtoo on 6/20/2015.
 * Updated by Kraisorn Rakam on 7/03/2015.
 */
public abstract class ImmortalMovementBase extends ImmortalBase {

    private float speed;

    public ImmortalMovementBase(String name, float x, float y, float speed) {
        super(name, x, y);
        this.speed = speed;
    }

    public ImmortalMovementBase(String name, Vector2 geometry, float speed) {
        super(name, geometry);
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

}
