package com.gedev.game.android;

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
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
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

    Vector2[] mWayPoints = new Vector2[]{
            new Vector2(28, 9)
            , new Vector2(27, 9)
            , new Vector2(26, 9)
            , new Vector2(25, 9)
            , new Vector2(24, 9)
            , new Vector2(23, 9)
            , new Vector2(22, 9)
            , new Vector2(22, 10)
            , new Vector2(22, 11)
            , new Vector2(22, 12)
            , new Vector2(21, 12)
            , new Vector2(20, 12)
            , new Vector2(19, 12)
            , new Vector2(18, 12)
            , new Vector2(17, 12)
            , new Vector2(16, 12)
            , new Vector2(16, 11)
            , new Vector2(16, 10)
            , new Vector2(16, 9)
            , new Vector2(16, 8)
            , new Vector2(16, 7)
            , new Vector2(16, 6)
            , new Vector2(16, 5)
            , new Vector2(16, 4)
            , new Vector2(16, 3)
            , new Vector2(16, 2)
            , new Vector2(15, 2)
            , new Vector2(14, 2)
            , new Vector2(13, 2)
            , new Vector2(12, 2)
            , new Vector2(11, 2)
            , new Vector2(10, 2)
            , new Vector2(9, 2)
            , new Vector2(8, 2)
            , new Vector2(7, 3)
            , new Vector2(7, 4)
            , new Vector2(7, 5)
            , new Vector2(7, 6)
            , new Vector2(7, 7)
            , new Vector2(6, 7)
            , new Vector2(5, 7)
            , new Vector2(4, 7)
            , new Vector2(3, 7)
    };

    SpriteBatch sb;
    Texture texture;
    Sprite sprite;
    MapLayer objectLayer;
    TextureRegion textureRegion;

    CatmullRomSpline<Vector2> mCatmull;
    private int i = 0;
    private int lenght = mWayPoints.length;
    private float current = 0;
    private float speed = 0.15f;

    public ZIndex(){
        for(int a = 0 ; a < lenght ; a++){
            mWayPoints[a].x *= 64;
            mWayPoints[a].y *= 64;

        }
    }

    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.position.set((float) (camera.viewportWidth / 2), (float) (camera.viewportHeight / 2), 0);

        viewport = new StretchViewport(2048, 1536, camera);
        viewport.apply();

        scene = new TmxMapLoader().load("scene.tmx");
        MapLayer a = new MapLayer();

        Gdx.input.setInputProcessor(this);

        texture = new Texture(Gdx.files.internal("boss.png"));
        textureRegion = new TextureRegion(texture, 256, 256);
        objectLayer = scene.getLayers().get("monster");

        scene_renderer = new OrthoTileMapWithSprite(scene);
        mCatmull = new CatmullRomSpline<Vector2>(mWayPoints, true);

        TextureMapObject tmo = new TextureMapObject(textureRegion);

        tmo.setX(0);
        tmo.setY(0);

        objectLayer.getObjects().add(tmo);
    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        scene_renderer.setView(camera);
        scene_renderer.render();

        current += Gdx.graphics.getDeltaTime() * speed;
        if(current >= 1)
            current -= 1;

        travel(mCatmull.valueAt(new Vector2(mWayPoints[i].x,mWayPoints[i].y), current).x,mCatmull.valueAt(new Vector2(mWayPoints[i].x,mWayPoints[i].y), current).y);
        i++;

        if(i > lenght){
            i = 0;
        }
//
//        myCatmull.valueAt(out, current);
//        batch.draw(sprite, out.x, out.y);
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
/*        Vector3 clickCoordinates = new Vector3(screenX, screenY, 0);
        Vector3 position = camera.unproject(clickCoordinates);

        TextureMapObject character = (TextureMapObject) scene.getLayers().get("monster").getObjects().get(0);
        character.setX((float) position.x);
        character.setY((float) position.y);*/
//        this.travel();
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

    public void travel(float x,float y) {
//        Log.e("Testx",x+"");
//        Log.e("Testy",y+"");
        TextureMapObject character= (TextureMapObject) scene.getLayers().get("monster").getObjects().get(0);
        character.setX(x);
        character.setY(y);
//        Vector2 walk;
//        Vector3 unproj;
//        float t;
//        int length = (mWayPoints.length - 1);
//        int i = 0;
//
//        while (i <= length) {
//            character = (TextureMapObject) scene.getLayers().get("monster").getObjects().get(0);
//            t = ((float) i / (float) length);
//            walk = new Vector2(mWayPoints[i].x * 64, mWayPoints[i].y * 64);
//            unproj = camera.unproject(new Vector3(mCatmull.valueAt(walk, t).x, mCatmull.valueAt(walk, t).y, 0.0f));
//
//            Log.e("Test", unproj.x + "");
//            Log.e("Test", unproj.y + "");
//
//            character.setX(unproj.x);
//            character.setX(unproj.y);
//            camera.update();

//            try {
//                this.render();
//                Thread.sleep(1000);
                i++;
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
//        }
        ;

    }
}
