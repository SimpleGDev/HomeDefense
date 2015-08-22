package com.gedev.game.android.base;

import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 03/7/2015.
 */
public abstract class Immortal extends TextureMapObject {

    public Immortal(String name, Vector2 geometry) {
        this(name, geometry.x, geometry.y);
    }

    public Immortal(String name, float x, float y) {
        setName(name);
        setGeometry(x, y);
    }

    public Vector2 getGeometry() {
        return new Vector2(getX(), getY());
    }

    public void setGeometry(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setGeometry(Vector2 geometry) {
        setGeometry(geometry.x, geometry.y);
    }

}
