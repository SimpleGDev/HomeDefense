package com.gedev.game.android.base;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

/**
 * Created by Kraisorn Rakam
 * Date 21/6/2558
 * Time 01:17 PM
 */
public interface RendererBase {

    public void setView(OrthographicCamera camera);

    public void setView(Matrix4 projection, float x, float y, float width, float height);

    public void render();

    public void dispose();

}
