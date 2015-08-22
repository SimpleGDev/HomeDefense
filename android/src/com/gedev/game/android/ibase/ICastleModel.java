package com.gedev.game.android.ibase;

import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.base.MortalBuilding;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 6/20/2015.
 */
public abstract class ICastleModel extends MortalBuilding {

    public ICastleModel(String name, float x, float y, int healthPoint) {
        super(name, x, y, healthPoint);
    }

    public ICastleModel(String name, Vector2 geometry, int healthPoint) {
        super(name, geometry, healthPoint);
    }

}
