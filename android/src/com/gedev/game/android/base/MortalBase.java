package com.gedev.game.android.base;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Mr. Kraisorn Rakam on 8/1/2015.
 */
public abstract class MortalBase extends ObjectBase {

    private TextureMapObject object;

    public MortalBase(String name, float x, float y, int health) {
        super(name);

        object = new TextureMapObject();
        object.setName(name + "-object");

        setGeometry(x, y);
        setHealth(health);

        getObjects().add(object);
    }

    public MortalBase(String name, Vector2 geometry, int health) {
        this(name, geometry.x, geometry.y, health);
    }

    public Vector2 getGeometry() {
        return new Vector2(object.getX(), object.getY());
    }

    public int getHealth() {
        return (int) object.getProperties().get("health");
    }

    public TextureRegion getView() {
        return object.getTextureRegion();
    }

    public TextureMapObject getObject() {
        return object;
    }

    public void setGeometry(float x, float y) {
        object.setX(x);
        object.setY(y);
    }

    public void setGeometry(Vector2 geometry) {
        setGeometry(geometry.x, geometry.y);
    }

    public void setHealth(int health) {
        object.getProperties().put("health", health);
    }

    public void setView(TextureRegion view) {
        object.setTextureRegion(view);
    }

    public void setObject(TextureMapObject object) {
        this.object = object;
    }

}
