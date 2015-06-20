package com.gedev.game.android.object;

import java.util.ArrayList;

/**
 * Created by ultimate on 6/20/2015.
 */
public abstract class ImmortalMovementBase extends ImmortalBase{
    private float speed;

    public ImmortalMovementBase(String name, ArrayList<Float> mGeometry, float speed) {
        super(name, mGeometry);
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
