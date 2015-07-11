package com.gedev.game.android.mstate;

import com.badlogic.gdx.math.Vector2;
import com.gedev.game.android.ibase.IStageBase;

import java.util.ArrayList;

/**
 * Created by Kraisorn Rakam
 * Date 11/7/2558
 * Time 12:02 น.
 */
public class StageOne extends IStageBase {

    public StageOne(String name) {
        super("stage one");
    }

    public StageOne(String name, ArrayList<Vector2> wayPoints) {
        super(name, wayPoints);
    }
}
