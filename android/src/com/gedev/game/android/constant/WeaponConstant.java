package com.gedev.game.android.constant;

import java.util.Arrays;

public final class WeaponConstant {

    public static final String BOOM = "WEAPON_TYPE_BOOM";
    public static final String FAR = "WEAPON_TYPE_FAR";
    public static final String NEAR = "WEAPON_TYPE_NEAR";

    public static boolean hasType(String type) {
        return Arrays.asList(WeaponConstant.getTypes()).contains(type) ;
    }

    public static String[] getTypes() {
        return new String[] {
                WeaponConstant.BOOM,
                WeaponConstant.FAR,
                WeaponConstant.NEAR
        };
    }

}
