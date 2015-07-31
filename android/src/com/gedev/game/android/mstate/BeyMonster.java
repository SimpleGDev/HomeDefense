package com.gedev.game.android.mstate;

import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.ibase.IMonsterModelBase;

/**
 * Created by Mr. Kraisorn Rakam.
 * 8/1/2015
 * 2:36 AM
 */
public class BeyMonster extends IMonsterModelBase {

    public BeyMonster(Vector2 geometry) {
        super("Bey", geometry, 10, 0.25f, 3);
    }

}
