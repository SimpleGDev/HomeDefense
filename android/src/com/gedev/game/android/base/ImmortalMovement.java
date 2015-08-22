package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by dreamtoo on 6/20/2015.
 * Updated by Kraisorn Rakam on 7/03/2015.
 */
public abstract class ImmortalMovement extends Immortal {

    public ImmortalMovement(String name, Vector2 geometry, float speed) {
        this(name, geometry.x, geometry.y, speed);
    }

    public ImmortalMovement(String name, float x, float y, float speed) {
        super(name, x, y);

        setSpeed(speed);
    }

    public float getSpeed() {
        return (float) getProperties().get("speed");
    }

    public void setSpeed(float speed) {
        getProperties().put("speed", speed);
    }

}
