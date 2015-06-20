package com.gedev.game.android.object;

import java.util.ArrayList;

/**
 * Created by ultimate on 6/20/2015.
 */
public class WeaponBase extends ImmortalBase {

    private float range;
    private int damage;
    private float distance;
    private float cooldown;

    public WeaponBase(String name, ArrayList<Float> mGeometry, float range, int damage, float distance, float cooldown) {
        super(name, mGeometry);
        this.range = range;
        this.damage = damage;
        this.distance = distance;
        this.cooldown = cooldown;
    }

    public float getRange() {
        return range;
    }

    public void setRange(float range) {
        this.range = range;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public float getDistance() {
        return distance;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public float getCooldown() {
        return cooldown;
    }

    public void setCooldown(float cooldown) {
        this.cooldown = cooldown;
    }
}
