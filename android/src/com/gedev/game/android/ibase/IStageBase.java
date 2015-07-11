package com.gedev.game.android.ibase;

import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.base.ObjectBase;

import java.util.ArrayList;

/**
 * Created by Kraisorn Rakam
 * Date 4/7/2558
 * Time 8:58 AM
 */
public abstract class IStageBase extends ObjectBase {

    private ArrayList<Vector2> wayPoints = new ArrayList<Vector2>();

    public IStageBase(String name) {
        super(name);
    }

    public IStageBase(String name, ArrayList<Vector2> wayPoints) {
        super(name);
        this.wayPoints = wayPoints;
    }

    public void addWayPoint(Vector2 point) {
        wayPoints.add(point);
    }

    public void removeWayPoint(Vector2 point) {
        wayPoints.remove(point);
    }

    public ArrayList<Vector2> getWayPoints() {
        return wayPoints;
    }

    public void setWayPoints(ArrayList<Vector2> wayPoints) {
        this.wayPoints = wayPoints;
    }

}
