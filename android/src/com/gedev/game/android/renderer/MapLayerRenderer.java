package com.gedev.game.android.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.gedev.game.android.ibase.IRendererBase;

/**
 * Created by Mr. Kraisorn Rakam.
 * 8/2/2015
 * 1:08 PM
 */
public class MapLayerRenderer extends IRendererBase {

    private MapLayer layer;
    private MapObjectsRenderer objectsRenderer;

    public MapLayerRenderer() {this(null);}

    public MapLayerRenderer(MapLayer layer) {this(layer, null);}

    public MapLayerRenderer(MapLayer layer, OrthographicCamera camera) {
        super(camera);

        this.layer = layer;
        objectsRenderer = new MapObjectsRenderer();
    }

    public MapLayer getLayer() {return layer;}

    public void setLayer(MapLayer layer) {this.layer = layer;}

    @Override
    public void render() {
        if (layer == null || !layer.isVisible()) return;

        objectsRenderer.setBatch(batch);

        if (!batch.isDrawing()) batch.begin();

        objectsRenderer.setObjects(layer.getObjects());
        objectsRenderer.render();

        if (batch.isDrawing()) batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        objectsRenderer.dispose();
    }

}
