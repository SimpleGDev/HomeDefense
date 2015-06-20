package com.gedev.game.android.object;

import java.util.ArrayList;

/**
 * Created by ultimate on 6/20/2015.
 */
public abstract class ImmortalBase extends ObjectBase {
        private ArrayList<Float> mGeometry = new ArrayList<>();

    public ImmortalBase(String name, ArrayList<Float> mGeometry) {
        super(name);
        this.mGeometry = mGeometry;
    }

    public ArrayList<Float> getGeometry() {
        return mGeometry;
    }

    public void setGeometry(ArrayList<Float> mGeometry) {
        this.mGeometry = mGeometry;
    }
}
