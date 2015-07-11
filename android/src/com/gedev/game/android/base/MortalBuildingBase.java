package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 6/20/2015.
 */
public abstract class MortalBuildingBase extends MortalBase {

    public MortalBuildingBase(String name, float x, float y, int healthPoint) {
        super(name, x, y, healthPoint);
    }

    public MortalBuildingBase(String name, Vector2 geometry, int healthPoint) {
        super(name, geometry, healthPoint);
    }

}
