package com.gedev.game.android.base;

import com.gedev.game.android.constant.MagicConstant;

public abstract class MagicBase extends AbilityBase {

    private String magicType;
    private float speed;
    private float damage;
    private float distance;
    private float radius;

    public MagicBase(String abilityType, String magicType, String name, float speed, float damage, float coolDown, float distance, float radius) {
        super(abilityType, name, coolDown);

        setMagicType(magicType);
        setSpeed(speed);
        setDamage(damage);
        setDistance(distance);
        setRadius(radius);
    }

    public String getMagicType() {
        return magicType;
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

    public void setMagicType(String magicType) {
        if (MagicConstant.hasType(magicType)) this.magicType = magicType;
        else throw new IllegalArgumentException("Magic type is invalid.");
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
