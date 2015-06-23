package com.gedev.game.android.view;

import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.object.WeaponBase;
import com.gedev.game.android.tower.BaseTower;

/**
 * Created by ultimate on 6/20/2015.
 */
public class TowerView extends BaseTower {

    private TextureMapObject towerObject;
    private WeaponView weaponView;

    public TowerView(TiledMap world, String imagePath, String name, float x, float y, int width, int height, int radiusColor, float radius, TextureMapObject towerObject, WeaponView weaponView) {
        super(world, imagePath, name, x, y, width, height, radiusColor, radius);
        this.towerObject = towerObject;
        this.weaponView = weaponView;
    }

    public TowerView(TiledMap world, String imagePath, String name, Vector2 xy, int width, int height, int radiusColor, float radius, TextureMapObject towerObject, WeaponView weaponView) {
        super(world, imagePath, name, xy, width, height, radiusColor, radius);
        this.towerObject = towerObject;
        this.weaponView = weaponView;
    }

    public TextureMapObject getTowerObject() {
        return towerObject;
    }

    public void setTowerObject(TextureMapObject towerObject) {
        this.towerObject = towerObject;
    }

    public WeaponView getWeaponView() {
        return weaponView;
    }

    public WeaponBase getWeaponBase() {
        return weaponView.getWeaponBase();
    }

    public float getRange() {
        return weaponView.getWeaponBase().getRange();
    }

    public int getDamage() {
        return weaponView.getWeaponBase().getDamage();
    }

    public float getDistance() {
        return weaponView.getWeaponBase().getDistance();
    }

    public float getCooldown() {
        return weaponView.getWeaponBase().getCooldown();
    }

    public void setWeaponView(WeaponView weaponView) {
        this.weaponView = weaponView;
    }
}
