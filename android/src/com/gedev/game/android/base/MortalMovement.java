package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 6/20/2015.
 */
public abstract class MortalMovement extends Mortal {

    public MortalMovement(String name, Vector2 geometry, int health, float speed) {
        this(name, geometry.x, geometry.y, health, speed);
    }

    public MortalMovement(String name, float x, float y, int health, float speed) {
        super(name, x, y, health);

        setSpeed(speed);
    }

    public float getSpeed() {
        return (float) getProperties().get("speed");
    }

    public void setSpeed(float speed) {
        getProperties().put("speed", speed);
    }

}
