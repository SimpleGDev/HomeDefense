package com.gedev.game.android.base;

import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 6/20/2015.
 */
public abstract class MortalBuilding extends Mortal {

    public MortalBuilding(String name, Vector2 geometry, int health) {
        this(name, geometry.x, geometry.y, health);
    }

    public MortalBuilding(String name, float x, float y, int health) {
        super(name, x, y, health);
    }

}
