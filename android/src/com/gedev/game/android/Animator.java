package com.gedev.game.android;

import android.util.Log;

import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Animation;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;

/**
 * Created by Kraisorn Rakam
 * Date 11/7/2558
 * Time 13:24 น.
 */
public class Animator implements ApplicationListener, InputProcessor {

    private static final int FRAME_COLS = 7;         // #1
    private static final int FRAME_ROWS = 4;         // #2

    Animation walkAnimation;          // #3
    Texture walkSheet;              // #4
    TextureRegion[] walkFrames;             // #5
    TextureRegion[] walkFlipFrames;             // #5
    SpriteBatch spriteBatch;            // #6
    TextureRegion currentFrame;           // #7

    float stateTime;                                        // #8
    float position = 0f;
    float go = -7f;
    boolean flip = true;

    @Override
    public void create() {
        walkSheet = new Texture(Gdx.files.internal("running03.png")); // #9
        TextureRegion[][] tmp = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight() / FRAME_ROWS);              // #10
        TextureRegion[][] tmpFlip = TextureRegion.split(walkSheet, walkSheet.getWidth() / FRAME_COLS, walkSheet.getHeight() / FRAME_ROWS);              // #10
        walkFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];
        walkFlipFrames = new TextureRegion[FRAME_COLS * FRAME_ROWS];

        int index = 0;

        for (int i = 0; i < FRAME_ROWS; i++) {
            for (int j = 0; j < FRAME_COLS; j++) {
                walkFrames[index] = tmp[i][j];
                walkFlipFrames[index] = tmpFlip[i][j];
                walkFlipFrames[index].flip(true, false);

                index++;
            }
        }

        spriteBatch = new SpriteBatch();                // #12
        stateTime = 0f;                         // #13
    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void render() {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);                        // #14

        if (position <= 0 || position >= Gdx.graphics.getWidth()) go *= -1;
        if (position <= 0) walkAnimation = new Animation(0.025f, walkFrames);
        if (position >= Gdx.graphics.getWidth()) walkAnimation = new Animation(0.025f, walkFlipFrames);

        stateTime += Gdx.graphics.getDeltaTime();           // #15
        position += go;

        currentFrame = walkAnimation.getKeyFrame(stateTime, true);  // #16

        spriteBatch.begin();
        spriteBatch.draw(currentFrame, position, 50);             // #17
        spriteBatch.end();
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {

    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }
}