package com.gedev.game.android.object;

import java.util.ArrayList;

/**
 * Created by ultimate on 6/20/2015.
 */
public abstract class MortalBuilding extends MortalBase {
    public MortalBuilding(String name, ArrayList<Float> mGeometry, int mHealthPoint) {
        super(name, mGeometry, mHealthPoint);
    }
}
