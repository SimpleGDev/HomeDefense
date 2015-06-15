package com.gedev.game.android.base;

public abstract class AbilityObjectBase extends AbilityBase {

    private float speed;
    private float damage;
    private float distance;
    private float radius;

    public AbilityObjectBase(String abilityType, String name, float speed, float damage, float coolDown, float distance, float radius) {
        super(abilityType, name, coolDown);
        initialize(speed, damage, distance, radius);

    }

    public AbilityObjectBase(String abilityType, String name, float speed, float damage, CoolDownBase coolDownInstance, float distance, float radius) {
        super(abilityType, name, coolDownInstance);
        initialize(speed, damage, distance, radius);
    }

    private void initialize(float speed, float damage, float distance, float radius) {
        setSpeed(speed);
        setDamage(damage);
        setDistance(distance);
        setRadius(radius);
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

    public void setSpeed(float speed) {
        if(speed >= 1.0f) this.speed = speed;
        else throw new IllegalArgumentException("Ability speed is invalid, it must have at least 1.0f.");
    }

    public void setDamage(float damage) {
        if(damage >= 0.0f) this.damage = damage;
        else throw new IllegalArgumentException("Ability damage is invalid, it must have at least 0.0f.");
    }

    public void setDistance(float distance) {
        if(distance >= 0.0f) this.distance = distance;
        else throw new IllegalArgumentException("Ability distance is invalid, it must have at least 0.0f.");
    }

    public void setRadius(float radius) {
        if(radius >= 1.0f) this.radius = radius;
        else throw new IllegalArgumentException("Ability radius is invalid, it must have at least 1.0f.");
    }

}
