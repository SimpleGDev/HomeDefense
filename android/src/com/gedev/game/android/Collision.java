package com.gedev.game.android;

import android.util.Log;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.Color;
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
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;
import com.gedev.game.android.object.WeaponBase;
import com.gedev.game.android.view.TowerView;
import com.gedev.game.android.view.WeaponView;

import java.util.ArrayList;

/**
 * Created by ultimate on 6/6/2015.
 */
public class Collision extends ApplicationAdapter implements InputProcessor {

    Vector2[] mWayPoints = new Vector2[]{
            new Vector2(28, 9)
            , new Vector2(27, 9)
            , new Vector2(26, 9)
            , new Vector2(25, 9)
            , new Vector2(24, 9)
            , new Vector2(23, 9)
            , new Vector2(22, 9)
            , new Vector2(21, 9)
            , new Vector2(20, 9)
            , new Vector2(19, 9)
            , new Vector2(18, 9)
            , new Vector2(17, 9)
            , new Vector2(16, 9)
            , new Vector2(15, 9)
            , new Vector2(14, 9)
            , new Vector2(13, 9)
            , new Vector2(12, 9)
            , new Vector2(11, 9)
            , new Vector2(10, 9)
            , new Vector2(9, 9)
            , new Vector2(8, 9)

    };

    private TiledMap scene;
    private OrthoTileMapWithSprite scene_renderer;
    private OrthographicCamera camera;
    private Viewport viewport;

    SpriteBatch sb;
    Texture texture, texture2;
    Sprite sprite;
    MapLayer objectLayer, objectLayer2;
    TextureRegion textureRegion, textureRegion2;
    TextureMapObject tmo, tmo2;
    CatmullRomSpline<Vector2> mCatmull;
    private int i = 0;
    private int lenght = mWayPoints.length;
    private float current = 0;
    private float speed = 0.15f;
    Rectangle mRectangle, mRectangle2;
    Circle mCircle;

    public Collision() {
        for (int a = 0; a < lenght; a++) {
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

        Gdx.input.setInputProcessor(this);

        texture = new Texture(Gdx.files.internal("boss.png"));
//        texture2 = new Texture(Gdx.files.internal("tile_question_box.png"));

        objectLayer = scene.getLayers().get("monster");
//        objectLayer2 = scene.getLayers().get("object_collision");

        textureRegion = new TextureRegion(texture, 256, 256);
//        textureRegion2 = new TextureRegion(texture2, 256, 256);

        scene_renderer = new OrthoTileMapWithSprite(scene);
        mCatmull = new CatmullRomSpline<Vector2>(mWayPoints, true);

        tmo = new TextureMapObject(textureRegion);

        tmo.setX(0);
        tmo.setY(0);

////        tmo2 = new TextureMapObject(textureRegion2);
//
//        tmo2.setX(18 * 64);
//        tmo2.setY(9 * 64);

        objectLayer.getObjects().add(tmo);
//        objectLayer2.getObjects().add(tmo2);

        mRectangle = new Rectangle(tmo.getX(), tmo.getY(), tmo.getTextureRegion().getRegionWidth(), tmo.getTextureRegion().getRegionHeight());
//        mRectangle2 = new Rectangle(tmo2.getX(), tmo2.getY(), tmo2.getTextureRegion().getRegionWidth(), tmo2.getTextureRegion().getRegionHeight());
        mCircle = new Circle(18 * 64, 9 * 64, 50.0f);

        ArrayList<Float> arrFloat =  new ArrayList<Float>();
        arrFloat.add(3.0f);
        MapLayer basetower = new TowerView(scene, "tile_question_box.png", "arrow_tower_level_1", 18 * 64, 9 * 64, 256, 256, Color.rgba4444(128, 255, 255, 255), 1000
                ,tmo,new WeaponView(new WeaponBase("Base", arrFloat,10,9,10.0f,1.0f)));

        TowerView tower = (TowerView) basetower;

        Log.e("Test", tower.getDamage()+"");
    }

    @Override
    public void render() {
//        Log.e("Test1",tmo2.getOriginX()+"");
//        Log.e("Test2", tmo2.getScaleX() + "");
//        Log.e("Test3", tmo2.getX() + "");
//        test.overlaps();


        Gdx.gl.glClearColor(1, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        scene_renderer.setView(camera);
        scene_renderer.render();

        current += Gdx.graphics.getDeltaTime() * speed;
        if (current >= 1)
            current -= 1;

        travel(mCatmull.valueAt(new Vector2(mWayPoints[i].x, mWayPoints[i].y), current).x, mCatmull.valueAt(new Vector2(mWayPoints[i].x, mWayPoints[i].y), current).y);
        i++;

        if (i > lenght) {
            i = 0;
        }


        //Test Overlap


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

    public void travel(float x, float y) {
//        Log.e("Testx",x+"");
//        Log.e("Testy",y+"");
        TextureMapObject character = (TextureMapObject) scene.getLayers().get("monster").getObjects().get(0);


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
//        ;


//        mRectangle.set(x, y, character.getTextureRegion().getRegionWidth(), character.getTextureRegion().getRegionHeight());

//        if (mRectangle.overlaps(mRectangle2)) {
//            scene.getLayers().remove(scene.getLayers().get("object_collision"));
//        }
    }
}