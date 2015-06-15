package com.gedev.game.android.constant;

import java.lang.reflect.Field;
import java.util.ArrayList;

public final class CoolDownConstant {

    public static final float COOL_DOWN_STEP = 0.3f;

    public static boolean hasConstant(String constant) {
        return CoolDownConstant.getConstants().contains(constant) ;
    }

    public static ArrayList<String> getConstants() {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = CoolDownConstant.class.getFields();

        for(Field constantField : constantFields)
            try { constants.add(String.valueOf(constantField.get(null))); }
            catch (IllegalAccessException exception) { throw new IllegalAccessError("Cool down constant field is invalid."); }

        return constants;
    }

    public static ArrayList<String> getConstantsByPrefixName(String prefixName) {
        ArrayList<String> constants = new ArrayList<>();
        Field[] constantFields = CoolDownConstant.class.getFields();

        for(Field constantField : constantFields)
            if(constantField.getName().startsWith(prefixName))
                try { constants.add(String.valueOf(constantField.get(null))); }
                catch (IllegalAccessException exception) { throw new IllegalAccessError("Cool down constant field is invalid."); }

        return constants;
    }

}
