package com.gedev.game.android.view;

import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.TextureMapObject;

/**
 * Created by ultimate on 6/20/2015.
 */
public class CastleView extends MapLayer{
    private TextureMapObject castleMapObject;
    private WeaponView weaponView;

    public CastleView(TextureMapObject castleMapObject, WeaponView weaponView) {
        this.castleMapObject = castleMapObject;
        this.weaponView = weaponView;
    }

    public TextureMapObject getCastleMapObject() {
        return castleMapObject;
    }

    public void setCastleMapObject(TextureMapObject castleMapObject) {
        this.castleMapObject = castleMapObject;
    }

    public WeaponView getWeaponView() {
        return weaponView;
    }

    public void setWeaponView(WeaponView weaponView) {
        this.weaponView = weaponView;
    }
}
