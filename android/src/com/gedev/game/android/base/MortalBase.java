package com.gedev.game.android.base;

import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Mr. Kraisorn Rakam on 8/1/2015.
 */
public abstract class MortalBase extends TextureMapObject {

    public MortalBase(String name, float x, float y, int health) {
        setName(name);

        setGeometry(x, y);
        setHealth(health);
    }

    public MortalBase(String name, Vector2 geometry, int health) {
        this(name, geometry.x, geometry.y, health);
    }

    public Vector2 getGeometry() {
        return new Vector2(getX(), getY());
    }

    public int getHealth() {
        return (int) getProperties().get("health");
    }

    public void setGeometry(float x, float y) {
        setX(x);
        setY(y);
    }

    public void setGeometry(Vector2 geometry) {
        setGeometry(geometry.x, geometry.y);
    }

    public void setHealth(int health) {
        getProperties().put("health", health);
    }

}
