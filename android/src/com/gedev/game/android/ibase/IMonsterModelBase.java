package com.gedev.game.android.ibase;

import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.base.MortalMovementBase;

/**
 * Created by ultimate on 6/20/2015.
 * Created by Kraisorn Rakam on 7/03/2015.
 */
public abstract class IMonsterModelBase extends MortalMovementBase {

    private int damage;
    private int gold = 0;

    public IMonsterModelBase(String name, float x, float y, int healthPoint, float speed, int damage) {
        super(name, x, y, healthPoint, speed);
        this.damage = damage;
    }

    public IMonsterModelBase(String name, float x, float y, int healthPoint, float speed, int damage, int gold) {
        super(name, x, y, healthPoint, speed);
        this.damage = damage;
        this.gold = gold;
    }

    public IMonsterModelBase(String name, Vector2 geometry, int healthPoint, float speed, int damage) {
        super(name, geometry, healthPoint, speed);
        this.damage = damage;
    }

    public IMonsterModelBase(String name, Vector2 geometry, int healthPoint, float speed, int damage, int gold) {
        super(name, geometry, healthPoint, speed);
        this.damage = damage;
        this.gold = gold;
    }

    public int getDamage() {
        return damage;
    }

    public int getGold() {
        return gold;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }

}
