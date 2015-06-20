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
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ultimate on 6/20/2015.
 */
public class TestScene  extends ApplicationAdapter implements InputProcessor {
    private TiledMap scene;
    private TiledMapRenderer scene_renderer;
    private OrthographicCamera camera;
    private Viewport viewport;
    private Vector2 touch_started;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.position.set((float) (camera.viewportWidth / 2), (float) (camera.viewportHeight / 2), 0);

        viewport = new StretchViewport(2048, 1536, camera);
        viewport.apply();

        scene = new TmxMapLoader().load("scene.tmx");
        scene_renderer = new OrthogonalTiledMapRenderer(scene);

        touch_started = new Vector2();

        Gdx.input.setInputProcessor(this);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        scene_renderer.setView(camera);
        scene_renderer.render();
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
//        touch_started.set((float) screenX, (float) screenY);
        return false;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
//        camera.translate((touch_started.x - (float)screenX), (screenY - touch_started.y));
//        touch_started.set((float) screenX, (float) screenY);
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

    @Override
    public void resize(int width, int height) {
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
        viewport.update(width, height);
    }

    public boolean isOutOfScreen(Vector3 position) {
        return false;
    }
}
