package com.gedev.game.android.object;

import java.util.ArrayList;

/**
 * Created by ultimate on 6/20/2015.
 */
public abstract class MortalBase extends ObjectBase{
    private ArrayList<Float> mGeometry = new ArrayList<>();
    private int mHealthPoint;

    public MortalBase(String name, ArrayList<Float> mGeometry, int mHealthPoint) {
        super(name);
        this.mGeometry = mGeometry;
        this.mHealthPoint = mHealthPoint;
    }

    public ArrayList<Float> gemGeometry() {
        return mGeometry;
    }

    public void setGeometry(ArrayList<Float> mGeometry) {
        this.mGeometry = mGeometry;
    }

    public int getHealthPoint() {
        return mHealthPoint;
    }

    public void setHealthPoint(int mHealthPoint) {
        this.mHealthPoint = mHealthPoint;
    }
}
