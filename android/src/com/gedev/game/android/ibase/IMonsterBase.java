package com.gedev.game.android.ibase;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.files.FileHandle;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.base.MortalMovementBase;

import java.util.logging.FileHandler;

/**
 * Created by ultimate on 6/20/2015.
 * Created by Kraisorn Rakam on 7/03/2015.
 */
public abstract class IMonsterBase extends MortalMovementBase {

    public IMonsterBase(String name, float x, float y, int health, float speed, int damage, int gold) {
        super(name, x, y, health, speed);

        setDamage(damage);
        setGold(gold);
    }

    public IMonsterBase(String name, Vector2 geometry, int health, float speed, int damage, int gold) {
        this(name, geometry.x, geometry.y, health, speed, damage, gold);
    }

    public IMonsterBase(String name, float x, float y, int health, float speed, int damage) {
        this(name, x, y, health, speed, damage, 0);
    }

    public IMonsterBase(String name, Vector2 geometry, int health, float speed, int damage) {
        this(name, geometry.x, geometry.y, health, speed, damage);
    }

    public int getDamage() {
        return (int) getObject().getProperties().get("damage");
    }

    public int getGold() {
        return (int) getObject().getProperties().get("gold");
    }

    public void setDamage(int damage) {
        getObject().getProperties().put("damage", damage);
    }

    public void setGold(int gold) {
        getObject().getProperties().put("gold", gold);
    }

}
