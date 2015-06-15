package com.gedev.game.android.base;

import com.badlogic.gdx.Screen;
import com.gedev.game.android.constant.CoolDownConstant;

public class CoolDownBase implements Screen {

    private float coolDown;
    private float coolDownTimer;

    public CoolDownBase(float coolDown) {
        setCoolDown(coolDown);
    }

    @Override
    public void show() {}

    @Override
    public void resize(int width, int height) {}

    @Override
    public void pause() {}

    @Override
    public void resume() {}

    @Override
    public void hide() {}

    @Override
    public void dispose() {}

    @Override
    public void render(float delta) {
        for (float timer = 0; timer < delta; timer += CoolDownConstant.COOL_DOWN_STEP)
            if (coolDownTimer < 0) coolDownTimer += coolDown;
            else if ((timer + CoolDownConstant.COOL_DOWN_STEP) > delta) coolDownTimer -= (delta - timer);
            else coolDownTimer -= CoolDownConstant.COOL_DOWN_STEP;
    }

    public float getCoolDown() {
        return coolDown;
    }

    public void setCoolDown(float coolDown) {
        if(coolDown >= 0) this.coolDown = coolDown;
        else throw new IllegalArgumentException("Cool down is invalid, it must have at least 0 seconds.");
    }
}
