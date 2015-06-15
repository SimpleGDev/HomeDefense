package com.gedev.game.android.base;

import com.gedev.game.android.constant.WeaponConstant;

public abstract class WeaponBase extends AbilityBase {

    private String weaponType;
    private float speed;
    private float damage;
    private float distance;
    private float radius;

    public WeaponBase(String abilityType, String weaponType, String name, float speed, float damage, float coolDown, float distance, float radius) {
        super(abilityType, name, coolDown);

        setWeaponType(weaponType);
        setSpeed(speed);
        setDamage(damage);
        setDistance(distance);
        setRadius(radius);
    }

    public String getWeaponType() {
        return weaponType;
    }

    public float getSpeed() {
        return speed;
    }

    public float getDamage() {
        return damage;
    }

    public float getDistance() {
        return distance;
    }

    public float getRadius() {
        return radius;
    }

    public void setWeaponType(String weaponType) {
        if (WeaponConstant.hasType(weaponType)) this.weaponType = weaponType;
        else throw new IllegalArgumentException("Weapon type is invalid.");
    }

    public void setSpeed(float speed) {
        this.speed = speed;
    }

    public void setDamage(float damage) {
        this.damage = damage;
    }

    public void setDistance(float distance) {
        this.distance = distance;
    }

    public void setRadius(float radius) {
        this.radius = radius;
    }
}
