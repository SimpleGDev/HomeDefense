package com.gedev.game.android.ibase;

import com.gedev.game.android.base.MortalMovement;

/**
 * Created by ultimate on 6/20/2015.
 * Created by Kraisorn Rakam on 7/03/2015.
 */
public abstract class IMonster extends MortalMovement {

    public IMonster(String name, float x, float y, int health, float speed, int damage) {this(name, x, y, health, speed, damage, 0);}

    public IMonster(String name, float x, float y, int health, float speed, int damage, int gold) {
        super(name, x, y, health, speed);

        setDamage(damage);
        setGold(gold);
    }

    public int getDamage() {return (int) getProperties().get("damage");}

    public int getGold() {return (int) getProperties().get("gold");}

    public void setDamage(int damage) {getProperties().put("damage", damage);}

    public void setGold(int gold) {getProperties().put("gold", gold);}

}
