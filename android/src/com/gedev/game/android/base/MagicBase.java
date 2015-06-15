package com.gedev.game.android.base;

import com.gedev.game.android.constant.MagicConstant;

public abstract class MagicBase extends AbilityObjectBase {

    private String magicType;

    public MagicBase(String abilityType, String magicType, String name, float speed, float damage, float coolDown, float distance, float radius) {
        super(abilityType, name, speed, damage, coolDown, distance, radius);
        initialize(magicType);
    }

    public MagicBase(String abilityType, String magicType, String name, float speed, float damage, CoolDownBase coolDownInstance, float distance, float radius) {
        super(abilityType, name, speed, damage, coolDownInstance, distance, radius);
        initialize(magicType);
    }

    private void initialize(String magicType) {
        setMagicType(magicType);
    }


    public String getMagicType() {
        return magicType;
    }

    public void setMagicType(String magicType) {
        if (MagicConstant.hasConstantType(magicType)) this.magicType = magicType;
        else throw new IllegalArgumentException("Magic type is invalid.");
    }

}
