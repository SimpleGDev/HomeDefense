package com.gedev.game.android.renderer;

import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.glutils.ShapeRenderer;
import com.badlogic.gdx.maps.MapObject;
import com.badlogic.gdx.maps.objects.CircleMapObject;
import com.badlogic.gdx.maps.objects.EllipseMapObject;
import com.badlogic.gdx.maps.objects.PolygonMapObject;
import com.badlogic.gdx.maps.objects.PolylineMapObject;
import com.badlogic.gdx.maps.objects.RectangleMapObject;
import com.badlogic.gdx.maps.objects.TextureMapObject;
import com.badlogic.gdx.math.Circle;
import com.badlogic.gdx.math.Ellipse;
import com.badlogic.gdx.math.Polygon;
import com.badlogic.gdx.math.Polyline;
import com.badlogic.gdx.math.Rectangle;
import com.gedev.game.android.ibase.IRenderer;

/**
 * Created by Mr. Kraisorn Rakam.
 * 8/2/2015
 * 2:10 PM
 */
public class ObjectRenderer extends IRenderer {

    private MapObject object;
    private ShapeRenderer shapeRenderer;

    public ObjectRenderer() {this(null);}

    public ObjectRenderer(MapObject object) {this(object, null);}

    public ObjectRenderer(MapObject object, OrthographicCamera camera) {
        super(camera);

        this.object = object;
        shapeRenderer = new ShapeRenderer();
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
    }

    public MapObject getObject() {return object;}

    public void setObject(MapObject object) {this.object = object;}

    @Override
    public void setBatch(SpriteBatch batch) {
        super.setBatch(batch);
        shapeRenderer.setProjectionMatrix(batch.getProjectionMatrix());
    }

    @Override
    public void render() {
        if (object == null || !object.isVisible()) return;
        if (!batch.isDrawing()) batch.begin();

        if (object instanceof TextureMapObject) renderTextureObject();
        else {
            shapeRenderer.begin(ShapeRenderer.ShapeType.Filled);
            shapeRenderer.setColor(object.getColor());

            renderShapeObject();

            shapeRenderer.end();
        }

        batch.end();
    }

    @Override
    public void dispose() {
        super.dispose();
        shapeRenderer.dispose();
    }

    private void renderTextureObject() {
        TextureMapObject object = (TextureMapObject) this.object;

        batch.draw(object.getTextureRegion(), object.getX(), object.getY());
    }

    private void renderShapeObject() {
        if (object instanceof CircleMapObject) {
            Circle circle = ((CircleMapObject) object).getCircle();

            shapeRenderer.circle(circle.x, circle.y, circle.radius);
        } else if (object instanceof EllipseMapObject) {
            Ellipse ellipse = ((EllipseMapObject) object).getEllipse();

            shapeRenderer.ellipse(ellipse.x, ellipse.y, ellipse.width, ellipse.height);
        } else if (object instanceof PolygonMapObject) {
            Polygon polygon = ((PolygonMapObject) object).getPolygon();

            shapeRenderer.polygon(polygon.getVertices());
        } else if (object instanceof PolylineMapObject) {
            Polyline polyline = ((PolylineMapObject) object).getPolyline();

            shapeRenderer.polyline(polyline.getVertices());
        } else if (object instanceof RectangleMapObject) {
            Rectangle rectangle = ((RectangleMapObject) object).getRectangle();

            shapeRenderer.rect(rectangle.x, rectangle.y, rectangle.width, rectangle.height);
        }
    }

}
