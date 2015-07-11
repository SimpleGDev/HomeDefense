package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 6/20/2015.
 */
public class ImmortalBuildingBase extends ImmortalBase {

    public ImmortalBuildingBase(String name, float x, float y) {
        super(name, x, y);
    }

    public ImmortalBuildingBase(String name, Vector2 geometry) {
        super(name, geometry);
    }

}
