package com.gedev.game.android.base;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Matrix4;

/**
 * Created by Kraisorn Rakam
 * Date 21/6/2558
 * Time 01:17 PM
 */
public interface Renderer {

    void setView(OrthographicCamera camera);

    void setView(Matrix4 projection, float x, float y, float width, float height);

    void render();

    void dispose();

}
