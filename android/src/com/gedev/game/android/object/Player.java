package com.gedev.game.android.object;

/**
 * Created by ultimate on 6/20/2015.
 */
public class Player extends ObjectBase {

    private int gold;

    public Player(String name, int gold) {
        super(name);
        this.gold = gold;
    }

    public int getGold() {
        return gold;
    }

    public void setGold(int gold) {
        this.gold = gold;
    }
}
