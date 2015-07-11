package com.gedev.game.android;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ultimate on 6/20/2015.
 * Updated by dreamtoo on 6/20/2015.
 */
public class Scene extends ApplicationAdapter {

    private TiledMap scene;
    private OrthogonalTiledMapRenderer sceneRenderer;
    private OrthographicCamera camera;
    private Viewport viewport;

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);

        viewport = new StretchViewport(2048, 1536, camera);
        viewport.apply();
        scene = new TmxMapLoader().load("scene.tmx");
        sceneRenderer = new OrthogonalTiledMapRenderer(scene);
    }

    @Override
    public void render() {
        Gdx.graphics.getGL20().glClearColor(1, 0, 0, 1);
        Gdx.graphics.getGL20().glClear(GL20.GL_COLOR_BUFFER_BIT | GL20.GL_DEPTH_BUFFER_BIT);

        camera.update();

        sceneRenderer.setView(camera);
        sceneRenderer.render();
    }

    @Override
    public void resize(int width, int height) {
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
        viewport.update(width, height);
    }
}
