package com.gedev.game.android;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gedev.game.android.mstate.Tutorial;

/**
 * Created by Kraisorn Rakam
 * Date 4/7/2558
 * Time 9:23 น.
 */
public class Game extends ApplicationAdapter {

    private OrthographicCamera camera;
    private Viewport viewport;
    private Tutorial tutorial;

    public Game() {
        camera = new OrthographicCamera();
        viewport = new StretchViewport(2048, 1536, camera);
    }

    @Override
    public void create() {
        viewport.apply(true);
        tutorial = new Tutorial();
    }

    @Override
    public void resize(int width, int height) {
        viewport.update(width, height);
    }

    @Override
    public void render() {
        Gdx.graphics.getGL20().glClearColor(1, 0, 0, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        camera.update();
        tutorial.render(camera);
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
}
