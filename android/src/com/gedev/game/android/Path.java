package com.gedev.game.android;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.math.CatmullRomSpline;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.utils.viewport.StretchViewport;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ultimate on 5/30/2015.
 */
public class Path extends ApplicationAdapter {

    Vector2[] mWayPoints = new Vector2[]{
            new Vector2(28, 9)
            , new Vector2(27, 9)
            , new Vector2(26, 9)
            , new Vector2(25, 9)
            , new Vector2(24, 9)
            , new Vector2(23, 9)
            , new Vector2(22, 9)
            , new Vector2(22, 8)
            , new Vector2(22, 7)
            , new Vector2(22, 6)
            , new Vector2(21, 6)
            , new Vector2(20, 6)
            , new Vector2(19, 6)
            , new Vector2(18, 6)
            , new Vector2(17, 6)
            , new Vector2(16, 6)
            , new Vector2(16, 7)
            , new Vector2(16, 8)
            , new Vector2(16, 9)
            , new Vector2(16, 10)
            , new Vector2(16, 11)
            , new Vector2(16, 12)
            , new Vector2(16, 13)
            , new Vector2(16, 14)
            , new Vector2(16, 15)
            , new Vector2(16, 16)
            , new Vector2(15, 16)
            , new Vector2(14, 16)
            , new Vector2(13, 16)
            , new Vector2(12, 16)
            , new Vector2(11, 16)
            , new Vector2(10, 16)
            , new Vector2(9, 16)
            , new Vector2(8, 16)
            , new Vector2(7, 16)
            , new Vector2(7, 15)
            , new Vector2(7, 14)
            , new Vector2(7, 13)
            , new Vector2(7, 12)
            , new Vector2(6, 12)
            , new Vector2(5, 12)
            , new Vector2(4, 12)
            , new Vector2(3, 12)};

    private OrthographicCamera camera;
    private Viewport viewport;
    private CatmullRomSpline<Vector2> mCatmull;
    private ShapeRenderer mShapeRenderer;


    @Override
    public void create() {
        camera = new OrthographicCamera();
        camera.position.set((float) (camera.viewportWidth / 2), (float) (camera.viewportHeight / 2), 0);

        viewport = new StretchViewport(1920, 1080, camera);
        viewport.apply();

        mCatmull = new CatmullRomSpline<Vector2>(mWayPoints, true);


        mShapeRenderer = new ShapeRenderer();

    }

    @Override
    public void render() {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();

        Vector2 out0;
        Vector2 out1;
        float t = 0;
        int length = mWayPoints.length - 1;

        mShapeRenderer.begin(ShapeRenderer.ShapeType.Line);
        mShapeRenderer.setColor(Color.BLACK);
        mShapeRenderer.setProjectionMatrix(camera.combined);

        for (int i = 0; i <= length; i++) {
            out0 = mWayPoints[i];

            out1 = ((i < length) ? mWayPoints[i + 1] : mWayPoints[i]);
//            t = (float) i / (float) length;
//
//            mCatmull.valueAt(out, t);
//            mCatmull.derivativeAt(out, t);
            if (i < length) {
                mShapeRenderer.line(out0.x * 64, out0.y * 64, 0.0f, out1.x * 64, out1.y * 64, 0.0f);
//                Log.e("Test", out.x + " | " + out.y);
            }
        }
        mShapeRenderer.end();
    }

    @Override
    public void resize(int width, int height) {
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
        viewport.update(width, height);
    }
}
