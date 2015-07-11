package com.gedev.game.android.mconstant;

import java.lang.reflect.Field;
import java.util.ArrayList;

public final class IObjectConstant {

    public static final String OBJECT_TYPE_MORTAL = "OBJECT_TYPE_MORTAL";
    public static final String OBJECT_TYPE_IMMORTAL = "OBJECT_TYPE_IMMORTAL";

    public static boolean hasConstant(String constant) {
        return IObjectConstant.getConstants().contains(constant) ;
    }

    public static boolean hasConstantType(String type) {
        return IObjectConstant.getConstantTypes().contains(type) ;
    }

    public static ArrayList<String> getConstants() {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = IObjectConstant.class.getFields();

        for(Field constantField : constantFields)
            try { constants.add(String.valueOf(constantField.get(null))); }
            catch (IllegalAccessException exception) { throw new IllegalAccessError("Object constant field is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantsByPrefixName(String prefixName) {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = IObjectConstant.class.getFields();

        for(Field constantField : constantFields)
            if(constantField.getName().startsWith(prefixName))
                try { constants.add(String.valueOf(constantField.get(null))); }
                catch (IllegalAccessException exception) { throw new IllegalAccessError("Object constant field is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantTypes() {
        return IObjectConstant.getConstantsByPrefixName("OBJECT_TYPE_");
    }

}
