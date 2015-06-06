package com.gedev.game.android.tower;


import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/6/2015.
 */
public class TowerRadiusObject extends CircleMapObject {

    private BaseTower mTower;
    private Color mColor;

    public TowerRadiusObject(BaseTower tower, String name, Color color, float centerX, float centerY, float radius) {
        this.initialize(tower, name, color, centerX, centerY, radius);
    }

    public TowerRadiusObject(BaseTower tower, String name, Color color, Vector2 center, float radius) {
        this.initialize(tower, name, color, center.x, center.y, radius);
    }

    private void initialize(BaseTower tower, String name, Color color, float centerX, float centerY, float radius) {
        mTower = tower;
        mColor = color;

        this.setName(name);
        this.setColor(mColor);
        this.getCircle().set(centerX, centerY, radius);

        mTower.getObjects().add(this);
    }
}
