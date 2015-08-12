package com.gedev.game.android;

import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Dialog;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Table;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.utils.viewport.Viewport;

/**
 * Created by ultimate on 6/23/2015.
 */
public class DialogTest2 extends Dialog implements InputProcessor,Screen {
    private Skin skin;
    private Stage stage;

    private Table table;
    private TextButton startButton;
    private TextButton quitButton;
    private Dialog mDialog;
    private SpriteBatch batch;
    private Sprite sprite;;

    private TiledMap scene;
    private OrthoTileMapWithSprite scene_renderer;
    private OrthographicCamera camera;
    private Viewport viewport;

    public DialogTest2(String Title,Skin uiSkin){
        super("TestDialog",new Skin());
    }

//    @Override
//    public void create () {
//        camera = new OrthographicCamera();
//        camera.position.set((float) (camera.viewportWidth), (float) (camera.viewportHeight), 0);
//
//        viewport = new StretchViewport(2048, 1536, camera);
//        viewport.apply();
//
//        scene = new TmxMapLoader().load("scene.tmx");
//
//        skin = new Skin(Gdx.files.internal("uiskin.json"));
//        stage = new Stage(viewport);
//        table = new Table();
//        table.setWidth(stage.getWidth());
//        table.align(Align.center);
//        table.setPosition(0,Gdx.graphics.getHeight());
//        startButton = new TextButton("New Game",skin);
//        quitButton = new TextButton("Quit Game",skin);
//
//        startButton.setSize(300f,200f);
//
//        startButton.addListener(new ClickListener() {
//            @Override
//            public void clicked(InputEvent event, float x, float y) {
//                Gdx.app.log("Clicked button", "Yep, you did");
////                event.stop();
//            }
//        });
//
//        table.padTop(30);
//        table.add(startButton).padBottom(30);
//        table.row();
//        table.add(quitButton);
//        stage.addActor(table);
//
//
//
////        batch = new SpriteBatch();
////        sprite = new Sprite(new Texture(Gdx.files.internal("boss.jpg")));
////        sprite.setSize(Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
//        scene_renderer = new OrthoTileMapWithSprite(scene);
//
//
//        // ORDER IS IMPORTANT!
//        InputMultiplexer im = new InputMultiplexer(stage,this);
//        Gdx.input.setInputProcessor(im);
//    }
//
//    @Override
//    public void render() {
//        Gdx.gl.glClearColor(1, 0, 0, 1);
//        Gdx.gl.glBlendFunc(GL20.GL_SRC_ALPHA, GL20.GL_ONE_MINUS_SRC_ALPHA);
//        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//        camera.update();
//
//        scene_renderer.setView(camera);
//        scene_renderer.render();
//    }

    @Override
    public void resize(int width, int height) {
        camera.position.set((camera.viewportWidth / 2), (camera.viewportHeight / 2), 0);
        viewport.update(width, height);
    }

    @Override
    public boolean keyDown(int keycode) {
        return false;
    }

    @Override
    public boolean keyUp(int keycode) {
        return false;
    }

    @Override
    public boolean keyTyped(char character) {
        return false;
    }

    @Override
    public boolean touchDown(int screenX, int screenY, int pointer, int button) {
        return true;
    }

    @Override
    public boolean touchUp(int screenX, int screenY, int pointer, int button) {
        return false;
    }

    @Override
    public boolean touchDragged(int screenX, int screenY, int pointer) {
        return false;
    }

    @Override
    public boolean mouseMoved(int screenX, int screenY) {
        return false;
    }

    @Override
    public boolean scrolled(int amount) {
        return false;
    }

    @Override
    public void pause() {

    }

    @Override
    public void resume() {

    }

    @Override
    public void dispose() {
    }

    @Override
    public void show() {
    }

    @Override
    public void render(float delta) {
    }

    @Override
    public void hide() {
    }
}