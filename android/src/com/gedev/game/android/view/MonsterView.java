package com.gedev.game.android.view;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.TextureMapObject;

/**
 * Created by ultimate on 6/20/2015.
 */
public class MonsterView extends MapLayer {
    TextureMapObject monsterObject;

    public MonsterView(TextureMapObject monsterObject) {
        this.monsterObject = monsterObject;
    }

    public TextureMapObject getMonsterObject() {
        return monsterObject;
    }

    public void setMonsterObject(TextureMapObject monsterObject) {
        this.monsterObject = monsterObject;
    }
}
