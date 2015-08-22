package com.gedev.game.android.ibase;

import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.base.Immortal;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by Kraisorn Rakam on 7/03/2015.
 */
public abstract class IWeaponModel extends Immortal {

    private float range;
    private int damage;
    private float distance;
    private float coolDown = 0.0f;

    public IWeaponModel(String name, float x, float y, float range, int damage, float distance) {
        super(name, x, y);
        initialize(range, damage, distance);
    }

    public IWeaponModel(String name, float x, float y, float range, int damage, float distance, float coolDown) {
        super(name, x, y);
        initialize(range, damage, distance, coolDown);
    }

    public IWeaponModel(String name, Vector2 geometry, float range, int damage, float distance) {
        super(name, geometry);
        initialize(range, damage, distance);
    }

    public IWeaponModel(String name, Vector2 geometry, float range, int damage, float distance, float coolDown) {
        super(name, geometry);
        initialize(range, damage, distance, coolDown);
    }

    private void initialize(float range, int damage, float distance) {
        setRange(range);
        setDamage(damage);
        setDistance(distance);
    }

    private void initialize(float range, int damage, float distance, float coolDown) {
        initialize(range, damage, distance);
        setCoolDown(coolDown);
    }

    public float getRange() {
        return range;
    }

    public int getDamage() {
        return damage;
    }

    public float getDistance() {
        return distance;
    }

    public float getCoolDown() {
        return coolDown;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setCoolDown(float coolDown) {
        this.coolDown = coolDown;
    }

}
