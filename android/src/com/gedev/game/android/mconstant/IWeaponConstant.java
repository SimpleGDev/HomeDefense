package com.gedev.game.android.mconstant;

import java.lang.reflect.Field;
import java.util.ArrayList;

public final class IWeaponConstant {

    public static final String WEAPON_TYPE_BOOM = "WEAPON_TYPE_BOOM";
    public static final String WEAPON_TYPE_FAR = "WEAPON_TYPE_FAR";
    public static final String WEAPON_TYPE_NEAR = "WEAPON_TYPE_NEAR";

    public static boolean hasConstant(String constant) {
        return IWeaponConstant.getConstants().contains(constant) ;
    }

    public static boolean hasConstantType(String type) {
        return IWeaponConstant.getConstantTypes().contains(type) ;
    }

    public static ArrayList<String> getConstants() {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = IWeaponConstant.class.getFields();

        for(Field constantField : constantFields)
            try { constants.add(String.valueOf(constantField.get(null))); }
            catch (IllegalAccessException exception) { throw new IllegalAccessError("Weapon constant field is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantsByPrefixName(String prefixName) {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = IWeaponConstant.class.getFields();

        for(Field constantField : constantFields)
            if(constantField.getName().startsWith(prefixName))
                try { constants.add(String.valueOf(constantField.get(null))); }
                catch (IllegalAccessException exception) { throw new IllegalAccessError("Weapon constant filed is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantTypes() {
        return IWeaponConstant.getConstantsByPrefixName("WEAPON_TYPE_");
    }

}
