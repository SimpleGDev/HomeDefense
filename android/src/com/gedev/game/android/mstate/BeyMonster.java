package com.gedev.game.android.mstate;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.ibase.IMonster;

/**
 * Created by Mr. Kraisorn Rakam.
 * 8/1/2015
 * 2:36 AM
 */
public class BeyMonster extends IMonster {

    public BeyMonster(float x, float y) {
        super("Bey", x, y, 10, 0.15f, 3);

        setTextureRegion(new TextureRegion(new Texture(Gdx.files.internal("bey.png")), 64, 64));
    }

    public BeyMonster(Vector2 geometry) {
        this(geometry.x, geometry.y);
    }

}
