package com.gedev.game.android.ibase;

import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.base.ImmortalBuildingBase;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 6/20/2015.
 */
public abstract class ITowerModelBase extends ImmortalBuildingBase {

    public ITowerModelBase(String name, float x, float y) {
        super(name, x, y);
    }

    public ITowerModelBase(String name, Vector2 geometry) {
        super(name, geometry);
    }

}
