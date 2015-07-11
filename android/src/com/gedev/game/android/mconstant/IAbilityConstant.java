package com.gedev.game.android.mconstant;

import java.lang.reflect.Field;
import java.util.ArrayList;

public class IAbilityConstant {

    public static final String ABILITY_TYPE_HEAL = "ABILITY_TYPE_HEAL";
    public static final String ABILITY_TYPE_ATTACK = "ABILITY_TYPE_ATTACK";

    public static boolean hasConstant(String constant) {
        return IAbilityConstant.getConstants().contains(constant) ;
    }

    public static boolean hasConstantType(String type) {
        return IAbilityConstant.getConstantTypes().contains(type) ;
    }

    public static ArrayList<String> getConstants() {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = IAbilityConstant.class.getFields();

        for(Field constantField : constantFields)
            try { constants.add(String.valueOf(constantField.get(null))); }
            catch (IllegalAccessException exception) { throw new IllegalAccessError("Ability constant field is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantsByPrefixName(String prefixName) {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = IAbilityConstant.class.getFields();

        for(Field constantField : constantFields)
            if(constantField.getName().startsWith(prefixName))
                try { constants.add(String.valueOf(constantField.get(null))); }
                catch (IllegalAccessException exception) { throw new IllegalAccessError("Ability constant field is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantTypes() {
        return IAbilityConstant.getConstantsByPrefixName("ABILITY_TYPE_");
    }

}
