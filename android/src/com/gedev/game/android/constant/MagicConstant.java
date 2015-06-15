package com.gedev.game.android.constant;

import java.util.Arrays;

public final class MagicConstant {

    public static final String THUNDER = "MAGIC_TYPE_THUNDER";
    public static final String FIRE = "MAGIC_TYPE_FIRE";
    public static final String AQUA = "MAGIC_TYPE_AQUA";

    public static boolean hasType(String type) {
        return Arrays.asList(MagicConstant.getTypes()).contains(type) ;
    }

    public static String[] getTypes() {
        return new String[] {
                MagicConstant.THUNDER,
                MagicConstant.FIRE,
                MagicConstant.AQUA
        };
    }

}
