package com.gedev.game.android.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.MapObjects;
import com.gedev.game.android.ibase.IRendererBase;

/**
 * Created by Mr. Kraisorn Rakam.
 * 8/2/2015
 * 1:08 PM
 */
public class MapObjectsRenderer extends IRendererBase {

    private MapObjects objects;
    private MapObjectRenderer objectRenderer;

    public MapObjectsRenderer() {this(null);}

    public MapObjectsRenderer(MapObjects objects) {this(objects, null);}

    public MapObjectsRenderer(MapObjects objects, OrthographicCamera camera) {
        super(camera);

        this.objects = objects;
        objectRenderer = new MapObjectRenderer();
    }

    public MapObjects getObjects() {return objects;}

    public void setObjects(MapObjects objects) {this.objects = objects;}

    @Override
    public void render() {
        if (objects == null) return;

        objectRenderer.setBatch(batch);

        if (!batch.isDrawing()) batch.begin();

        for (MapObject object : objects) {
            objectRenderer.setObject(object);
            objectRenderer.render();
        }

        if (batch.isDrawing()) batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        objectRenderer.dispose();
    }

}
