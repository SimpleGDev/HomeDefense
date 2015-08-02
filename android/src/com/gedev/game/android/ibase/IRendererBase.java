package com.gedev.game.android.ibase;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Matrix4;
import com.badlogic.gdx.math.Rectangle;
import com.gedev.game.android.base.RendererBase;

/**
 * Created by Kraisorn Rakam
 * Date 21/6/2558
 * Time 01:17 PM
 */
public abstract class IRendererBase implements RendererBase {

    protected SpriteBatch batch;
    protected Rectangle bounds;

    public IRendererBase() {this(null);}

    public IRendererBase(OrthographicCamera camera) {
        batch = new SpriteBatch();
        bounds = new Rectangle();

        setView(camera);
    }

    public SpriteBatch getBatch() {return batch;}

    public Rectangle getBounds() {return bounds;}

    public void setBatch(SpriteBatch batch) {this.batch = batch;}

    public void setBounds(Rectangle bounds) {this.bounds = bounds;}

    @Override
    public void setView(OrthographicCamera camera) {
        if (camera == null) return;

        float width = camera.viewportWidth * camera.zoom;
        float height = camera.viewportHeight * camera.zoom;

        setView(camera.combined, camera.position.x - (width / 2), camera.position.y - (height / 2), width, height);
    }

    @Override
    public void setView(Matrix4 projection, float x, float y, float width, float height) {
        batch.setProjectionMatrix(projection);
        bounds.set(x, y, width, height);
    }

    @Override
    public void render() {}

    @Override
    public void dispose() {batch.dispose();}

}
