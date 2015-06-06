package com.gedev.game.android.tower;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;

/**
 * Created by ultimate on 6/6/2015.
 */
public class BaseTower extends MapLayer {

    private TowerObject mTower;
    private TowerRadiusObject mTowerRadius;

    private TiledMap mWorld;

    public BaseTower(TiledMap world, String imagePath, String name, float x, float y, int width, int height, int radiusColor, float radius) {
        this.initialize(world, imagePath, name, x, y, width, height, radiusColor, radius);
    }

    public BaseTower(TiledMap world, String imagePath, String name, Vector2 xy, int width, int height, int radiusColor, float radius) {
        this.initialize(world, imagePath, name, xy.x, xy.y, width, height, radiusColor, radius);
    }

    private void initialize(TiledMap world, String imagePath, String name, float x, float y, int width, int height, int radiusColor, float radius) {
        mWorld = world;
        mTower = new TowerObject(this, new Texture(Gdx.files.internal(imagePath)), (name + TowerConstant.SUFFIX_TOWER_OBJECT_NAME), x, y, width, height);
        mTowerRadius = new TowerRadiusObject(this, (name + TowerConstant.SUFFIX_TOWER_RADIUS_OBJECT_NAME), radiusColor, (width / 2), (height / 2), radius);

        this.setName(name);

        mWorld.getLayers().add(this);
    }

}
