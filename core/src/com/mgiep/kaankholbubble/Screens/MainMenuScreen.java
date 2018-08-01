package com.mgiep.kaankholbubble.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.Vector3;
import com.mgiep.kaankholbubble.KaankholBubble;

import java.awt.Rectangle;

public class MainMenuScreen implements Screen {

    final KaankholBubble game;
    OrthographicCamera camera;
    private Texture startButtonTexture, background;


    public MainMenuScreen(KaankholBubble game) {
        this.game = game;
        startButtonTexture = new Texture(Gdx.files.internal("images/khelobutton.png"));
        background = new Texture(Gdx.files.internal("images/skybackground.png"));
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0.2f, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);

        game.batch.begin();
        game.batch.draw(background,0,0);
        game.batch.draw(startButtonTexture, 120-32, 800/2);
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 tmp = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
            camera.unproject(tmp);
            Rectangle textureBounds = new Rectangle(120-32, 800/2, 292, 83);
            if(textureBounds.contains(tmp.x,tmp.y)){
                game.setScreen(new GameScreen(game));
                dispose();
            }
        }
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

    }

    @Override
    public void dispose() {
        background.dispose();
        startButtonTexture.dispose();
    }
}
