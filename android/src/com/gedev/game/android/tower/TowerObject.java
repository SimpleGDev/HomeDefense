package com.gedev.game.android.tower;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/6/2015.
 */
public class TowerObject extends TextureMapObject {
    private BaseTower mTower;
    private Texture mImage;

    public TowerObject(BaseTower tower, Texture image, String name, float x, float y, int width, int height) {
        this.initialize(tower, image, name, x, y, width, height);
    }

    public TowerObject(BaseTower tower, Texture image, String name, Vector2 point, int width, int height) {
        this.initialize(tower, image, name, point.x, point.y, width, height);
    }

    private void initialize(BaseTower tower, Texture image, String name, float x, float y, int width, int height) {
        this.mTower = tower;
        this.mImage = image;

        this.setName(name);
        this.setTextureRegion(new TextureRegion(this.mImage, width, height));
        this.setX(x);
        this.setY(y);

        this.setColor(Color.BLUE);

        this.mTower.getObjects().add(this);
    }
}
