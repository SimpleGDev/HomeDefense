package com.gedev.game.android.view;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.TextureMapObject;

/**
 * Created by ultimate on 6/20/2015.
 */
public class TowerView extends MapLayer {
    private TextureMapObject towerObject;
    private WeaponView weaponView;

    public TowerView(TextureMapObject towerObject, WeaponView weaponView) {
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

    public void setWeaponView(WeaponView weaponView) {
        this.weaponView = weaponView;
    }
}
