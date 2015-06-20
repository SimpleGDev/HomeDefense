package com.gedev.game.android.object;

import java.util.ArrayList;

/**
 * Created by ultimate on 6/20/2015.
 */
public abstract class MortalMovementBase extends MortalBase{

    private float speed;

    public MortalMovementBase(String name, ArrayList<Float> mGeometry, int mHealthPoint, float speed) {
        super(name, mGeometry, mHealthPoint);
        this.speed = speed;
    }

    public float getSpeed() {
        return speed;
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }
}
