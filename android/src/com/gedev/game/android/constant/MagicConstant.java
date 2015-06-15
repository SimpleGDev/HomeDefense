package com.gedev.game.android.constant;

import java.lang.reflect.Field;
import java.util.ArrayList;

public final class MagicConstant {

    public static final String MAGIC_TYPE_THUNDER = "MAGIC_TYPE_THUNDER";
    public static final String MAGIC_TYPE_FIRE = "MAGIC_TYPE_FIRE";
    public static final String MAGIC_TYPE_AQUA = "MAGIC_TYPE_AQUA";

    public static boolean hasConstant(String constant) {
        return MagicConstant.getConstants().contains(constant) ;
    }

    public static boolean hasConstantType(String type) {
        return MagicConstant.getConstantTypes().contains(type) ;
    }

    public static ArrayList<String> getConstants() {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = MagicConstant.class.getFields();

        for(Field constantField : constantFields)
            try { constants.add(String.valueOf(constantField.get(null))); }
            catch (IllegalAccessException exception) { throw new IllegalAccessError("Magic constant field is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantsByPrefixName(String prefixName) {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = MagicConstant.class.getFields();

        for(Field constantField : constantFields)
            if(constantField.getName().startsWith(prefixName))
                try { constants.add(String.valueOf(constantField.get(null))); }
                catch (IllegalAccessException exception) { throw new IllegalAccessError("Magic constant field is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantTypes() {
        return MagicConstant.getConstantsByPrefixName("MAGIC_TYPE_");
    }

}
