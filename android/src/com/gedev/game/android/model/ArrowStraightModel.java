package com.gedev.game.android.model;

import com.gedev.game.android.base.WeaponBase;
import com.gedev.game.android.constant.WeaponConstant;

public class ArrowStraightModel extends WeaponBase {

    public ArrowStraightModel() {
        super(WeaponConstant.WEAPON_TYPE_NEAR, "Arrow Straight", 0.15f, 0.25f, 0.3f, 100.0f, 100.0f);
    }

}
