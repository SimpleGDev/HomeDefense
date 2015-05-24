package com.gedev.game.android;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TiledMapRenderer;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.ExtendViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

public class Scene extends ApplicationAdapter implements InputProcessor {

    /**
     * Instance variables
     */
    private TiledMap scene;
    private TiledMapRenderer scene_renderer;
    private OrthographicCamera camera;
    private Viewport viewport;

    private Vector2 touch_started;
    private float scale;

    /**
     * ApplicationAdapter overriding method
     */
    @Override
    public void create() {
        scene = new TmxMapLoader().load("scene.tmx");
        scene_renderer = new OrthogonalTiledMapRenderer(scene);
        camera = new OrthographicCamera(1920, 1080);
        viewport = new ExtendViewport(camera.viewportWidth, camera.viewportHeight, camera);
/*

        touch_started = new Vector2();
        scale = (Gdx.graphics.getWidth() / camera.viewportWidth);
*/

        viewport.apply();
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void resize(int width, int height) {
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        scene_renderer.setView(camera);
        scene_renderer.render();
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

    /**
     * InputProcessor overriding method
     */
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
