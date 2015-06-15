package com.gedev.game.android.constant;

import java.util.Arrays;

public class AbilityConstant {

    public static final String HEAL = "ABILITY_TYPE_HEAL";
    public static final String ATTACK = "ABILITY_TYPE_ATTACK";

    public static boolean hasConstantType(String type) {
        return Arrays.asList(AbilityConstant.getConstantTypes()).contains(type) ;
    }

    public static String[] getConstantTypes() {
        return new String[] {
                AbilityConstant.HEAL,
                AbilityConstant.ATTACK
        };
    }

}
