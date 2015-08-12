package com.gedev.game.android;

import android.util.Log;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.Pixmap;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.scenes.scene2d.Event;
import com.badlogic.gdx.scenes.scene2d.EventListener;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.utils.Drawable;
import com.badlogic.gdx.scenes.scene2d.utils.SpriteDrawable;

/**
 * Created by ultimate on 7/11/2015.
 */
public class DialogScene implements Screen{
    static Screen mScreen;
    static Stage mStage;
    static Dialog dialog;
    static Skin tileSkin;
    static TextButton btnYes;
    static TextButton btnNo;
    static String Title;

    public DialogScene(Stage stage,String title){
        mScreen = this;
        mStage = stage;
        Title = title;
    }

    static Drawable createDrawable (Color c) {
        Pixmap p = new Pixmap(1, 1, Pixmap.Format.RGBA8888);
        p.setColor(c);
        p.drawPixel(0, 0);
        return new SpriteDrawable(new Sprite(new Texture(p)));
    }

    @Override
    public void show() {
        tileSkin = new Skin(Gdx.files.internal("uiskin.json"));
        btnYes = new TextButton("Exit", tileSkin);
        btnNo = new TextButton("Cancel", tileSkin);

//        tileSkin.add("default", new BitmapFont());

        Skin skinDialog = new Skin(Gdx.files.internal("uiskin.json"));
        dialog = new Dialog(Title, skinDialog) {
            @Override
            public float getPrefWidth() {
//                 force dialog width
//                return Gdx.graphics.getWidth() / 2;
                return 700f;
            }

            @Override
            public float getPrefHeight() {
//                 force dialog height
//                return Gdx.graphics.getWidth() / 2;
                return 400f;
            }
        };

        dialog.addListener(new EventListener() {

            @Override
            public boolean handle(Event event) {
                return true;
            }
        });

        final boolean[] destroy = {false};

        btnYes.addListener(new EventListener() {
            @Override
            public boolean handle(Event event) {
                Log.e("Test", "EVENT NOW FCK U");
//                dialog.hide();
                if(!destroy[0]) {
                    mStage.dispose();
                    destroy[0] = true;
                }
                return true;
            }
        });

        Drawable test = createDrawable(Color.BLUE);
        Drawable test2 = createDrawable(Color.RED);

        dialog.setBackground(test);
        btnYes.setBackground(test2);
        dialog.setModal(true);
        dialog.setMovable(false);
        dialog.setResizable(false);

        dialog.getContentTable().add(btnYes).padTop(40f);
        dialog.getContentTable().add(btnNo).padTop(80f);
        dialog.show(mStage).setPosition(
                (1080 / 2) - (720 / 2),
                (1920) - (1920 - 40));

        dialog.setName("Title");
        Gdx.input.setInputProcessor(mStage);
    }

    @Override
    public void render(float delta) {

    }

    @Override
    public void resize(int width, int height) {

    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void hide() {
//        dialog.hide();

    }

    @Override
    public void dispose() {
    }
}
