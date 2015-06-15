package com.gedev.game.android.base;

import com.gedev.game.android.constant.AbilityConstant;
import com.gedev.game.android.constant.WeaponConstant;

public abstract class WeaponBase extends AbilityObjectBase {

    private String weaponType;

    public WeaponBase(String weaponType, String name, float speed, float damage, float coolDown, float distance, float radius) {
        super(AbilityConstant.ABILITY_TYPE_ATTACK, name, speed, damage, coolDown, distance, radius);
        initialize(weaponType);
    }

    public WeaponBase(String weaponType, String name, float speed, float damage, CoolDownBase coolDownInstance, float distance, float radius) {
        super(AbilityConstant.ABILITY_TYPE_ATTACK, name, speed, damage, coolDownInstance, distance, radius);
        initialize(weaponType);
    }

    private void initialize(String weaponType) {
        setWeaponType(weaponType);
    }

    public String getWeaponType() {
        return weaponType;
    }

    public void setWeaponType(String weaponType) {
        if (WeaponConstant.hasConstantType(weaponType)) this.weaponType = weaponType;
        else throw new IllegalArgumentException("Weapon type is invalid.");
    }

}
