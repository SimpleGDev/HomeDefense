package com.gedev.game.android.base;

import com.gedev.game.android.constant.AbilityConstant;

public abstract class AbilityBase {

    private String abilityType;
    private String name;
    private float coolDown;
    private CoolDownBase coolDownInstance;

    public AbilityBase(String abilityType, String name, float coolDown) {
        setAbilityType(abilityType);
        setName(name);
        setCoolDown(coolDown);
    }

    public AbilityBase(String abilityType, String name, CoolDownBase coolDownInstance) {
        setAbilityType(abilityType);
        setName(name);
        setCoolDownInstance(coolDownInstance);
    }

    public String getAbilityType() {
        return abilityType;
    }

    public String getName() {
        return name;
    }

    public float getCoolDown() {
        return coolDown;
    }

    public CoolDownBase getCoolDownInstance() {
        return coolDownInstance;
    }

    public void setAbilityType(String abilityType) {
        if (AbilityConstant.hasConstantType(abilityType)) this.abilityType = abilityType;
        else throw new IllegalArgumentException("Ability type is invalid.");
    }

    public void setName(String name) {
        if(name.length() >= 3) this.name = name;
        else throw new IllegalArgumentException("Ability name is invalid, it must have at least 3 characters.");
    }

    public void setCoolDown(float coolDown) {
        if(coolDown >= 0) {
            this.coolDown = coolDown;
            coolDownInstance = new CoolDownBase(this.coolDown);
        } else throw new IllegalArgumentException("Ability cool down is invalid, it must have at least 0 seconds.");
    }

    public void setCoolDownInstance(CoolDownBase coolDownInstance) {
        this.coolDownInstance = coolDownInstance;
        coolDown = this.coolDownInstance.getCoolDown();
    }

}
