package com.gedev.game.android.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.maps.MapLayer;
import com.gedev.game.android.ibase.IRenderer;

/**
 * Created by Mr. Kraisorn Rakam.
 * 8/2/2015
 * 1:08 PM
 */
public class LayerRenderer extends IRenderer {

    private MapLayer layer;
    private ObjectsRenderer objectsRenderer;

    public LayerRenderer() {this(null);}

    public LayerRenderer(MapLayer layer) {this(layer, null);}

    public LayerRenderer(MapLayer layer, OrthographicCamera camera) {
        super(camera);

        this.layer = layer;
        objectsRenderer = new ObjectsRenderer();
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
