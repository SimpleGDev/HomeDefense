package com.gedev.game.android.ibase;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Disposable;
import com.gedev.game.android.base.RendererBase;

/**
 * Created by Kraisorn Rakam on 21/6/2558 01:05 AM.
 * Updated by Kraisorn Rakam on 21/6/2558 01:09 PM.
 */
public abstract class IRendererBase implements RendererBase, Disposable {

    private SpriteBatch spriteBatch = new SpriteBatch();
    private OrthographicCamera camera;

    public IRendererBase(OrthographicCamera camera) {
        this.camera = camera;
    }

    public SpriteBatch getSpriteBatch() {
        return spriteBatch;
    }

    public OrthographicCamera getCamera() {
        return camera;
    }

    @Override
    public void render() {}

    @Override
    public void dispose() {
        if (spriteBatch.isDrawing()) spriteBatch.dispose();
    }

}
