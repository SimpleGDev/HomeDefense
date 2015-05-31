package com.gedev.game.android;

import android.util.Log;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.TextureRegion;
import com.badlogic.gdx.maps.MapLayer;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ultimate on 5/23/2015.
 */
public class ZIndex extends ApplicationAdapter implements InputProcessor {

    private TiledMap scene;
    private OrthoTileMapWithSprite scene_renderer;
    private OrthographicCamera camera;
    private Viewport viewport;

    SpriteBatch sb;
    Texture texture;
    Sprite sprite;
    MapLayer objectLayer;
    TextureRegion textureRegion;
    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.position.set((float) (camera.viewportWidth / 2), (float) (camera.viewportHeight / 2), 0);

        viewport = new StretchViewport(1920, 1080, camera);
        viewport.apply();

//        sb = new SpriteBatch();
//        texture = new Texture(Gdx.files.internal("monster.gif"));
//        sprite = new Sprite(texture);

        scene = new TmxMapLoader().load("scene.tmx");


//        scene_renderer.addSprite(sprite);

        Gdx.input.setInputProcessor(this);

        texture = new Texture(Gdx.files.internal("boss.png"));

        objectLayer = scene.getLayers().get("player");
        Log.e("Test","TESST::: "+objectLayer.getName());
        textureRegion = new TextureRegion(texture,256,256);

        TextureMapObject tmo = new TextureMapObject(textureRegion);
        Log.e("Test", "TESST::: " + tmo.getName());
        tmo.setX(0);
        tmo.setY(0);
        objectLayer.getObjects().add(tmo);

        scene_renderer = new OrthoTileMapWithSprite(scene);
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
        Vector3 clickCoordinates = new Vector3(screenX,screenY,0);
        Vector3 position = camera.unproject(clickCoordinates);
//        sprite.setPosition(position.x, position.y);
        TextureMapObject character = (TextureMapObject)scene.getLayers().get("player").getObjects().get(0);
        character.setX((float)position.x);
        character.setY((float)position.y);
        return true;
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

    @Override
    public void resize(int width, int height) {
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
        viewport.update(width, height);
    }
}
