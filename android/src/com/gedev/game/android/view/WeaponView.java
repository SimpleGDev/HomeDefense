package com.gedev.game.android.view;

import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.gedev.game.android.object.WeaponBase;

/**
 * Created by ultimate on 6/20/2015.
 */
public class WeaponView extends TextureMapObject {
    private WeaponBase weaponBase;

    public WeaponView(WeaponBase weaponBase) {
        this.weaponBase = weaponBase;
    }

    public WeaponView(TextureRegion textureRegion, WeaponBase weaponBase) {
        super(textureRegion);
        this.weaponBase = weaponBase;
    }

    public WeaponBase getWeaponBase() {
        return weaponBase;
    }

    public void setWeaponBase(WeaponBase weaponBase) {
        this.weaponBase = weaponBase;
    }
}
