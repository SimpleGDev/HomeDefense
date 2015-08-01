package com.gedev.game.android.mstate;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;
import com.badlogic.gdx.maps.tiled.renderers.OrthogonalTiledMapRenderer;
import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.ibase.IStageBase;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Kraisorn Rakam
 * Date 11/7/2558
 * Time 12:02 น.
 */
public class StageOne extends IStageBase {

    private final float BLOCK_SIZE = 64f;
    private TiledMap scene;
    private BeyMonster beyMonster;
    private OrthogonalTiledMapRenderer renderer;
    private Vector2[] wayBlocks = {
            // part 1.
            new Vector2(3f, 11f),
            new Vector2(4f, 11f),
            new Vector2(5f, 11f),
            new Vector2(6f, 11f),
            new Vector2(7f, 11f),
            new Vector2(8f, 11f),

            // part 2.
            new Vector2(8f, 10f),
            new Vector2(8f, 9f),
            new Vector2(8f, 8f),

            // part 3.
            new Vector2(9f, 8f),
            new Vector2(10f, 8f),
            new Vector2(11f, 8f),
            new Vector2(12f, 8f),
            new Vector2(13f, 8f),
            new Vector2(14f, 8f),
            new Vector2(15f, 8f),
            new Vector2(16f, 8f),
            new Vector2(17f, 8f),

            // part 4.
            new Vector2(17f, 9f),
            new Vector2(17f, 10f),
            new Vector2(17f, 11f),
            new Vector2(17f, 12f),
            new Vector2(17f, 13f),
            new Vector2(17f, 14f),
            new Vector2(17f, 15f),
            new Vector2(17f, 16f),
            new Vector2(17f, 17f),

            // part 5.
            new Vector2(18f, 17f),
            new Vector2(19f, 17f),
            new Vector2(20f, 17f),
            new Vector2(21f, 17f),
            new Vector2(22f, 17f),
            new Vector2(23f, 17f),

            // part 6.
            new Vector2(23f, 16f),
            new Vector2(23f, 15f),
            new Vector2(23f, 14f),

            // part 7.
            new Vector2(24f, 14f),
            new Vector2(25f, 14f),
            new Vector2(26f, 14f),
            new Vector2(27f, 14f),
            new Vector2(28f, 14f),
            new Vector2(29f, 14f),
            new Vector2(30f, 14f),
            new Vector2(31f, 14f),
    };

    public StageOne() {
        setWayPoints(generateWayBlocks()); // mul the way blocks by block size (64 pixel).

        scene = new TmxMapLoader().load("scene.tmx");
        beyMonster = new BeyMonster(getWayPoints().get(0));
        scene.getLayers().get("monster").getObjects().add(beyMonster);

//        MapLayers layers = scene.getLayers();
        renderer = new OrthogonalTiledMapRenderer(scene);
    }

    public void render(OrthographicCamera camera) {
        renderer.setView(camera);
        renderer.render();
    }

    private ArrayList<Vector2> generateWayBlocks() {
        int index = 0;
        int limit = wayBlocks.length;

        for (; index < limit; index++) wayBlocks[index].scl(BLOCK_SIZE);

        return new ArrayList<>(Arrays.asList(wayBlocks));
    }

}
