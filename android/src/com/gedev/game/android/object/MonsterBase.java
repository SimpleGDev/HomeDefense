package com.gedev.game.android.object;

import java.util.ArrayList;

/**
 * Created by ultimate on 6/20/2015.
 */
public class MonsterBase extends MortalMovementBase {
    private int damage;
    private int gold;

    public MonsterBase(String name, ArrayList<Float> mGeometry, int mHealthPoint, float speed, int damage, int gold) {
        super(name, mGeometry, mHealthPoint, speed);
        this.damage = damage;
        this.gold = gold;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
