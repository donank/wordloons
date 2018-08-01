package com.mgiep.kaankholbubble.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.TextureArray;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.math.Vector3;
import com.mgiep.kaankholbubble.KaankholBubble;

public class LevelSelectScreen implements Screen {

    final KaankholBubble game;
    OrthographicCamera camera;

    private Texture l1, l2, l3, l4, l5, l6, l7, l8, l9, l10;
    private Texture[][] levels;
    private int i = 0, j = 0;


    public LevelSelectScreen(KaankholBubble game) {
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);

        l1 = new Texture(Gdx.files.internal("images/l1.png"));
        l2 = new Texture(Gdx.files.internal("images/l2.png"));
        l3 = new Texture(Gdx.files.internal("images/l3.png"));
        l4 = new Texture(Gdx.files.internal("images/l4.png"));
        l5 = new Texture(Gdx.files.internal("images/l5.png"));
        l6 = new Texture(Gdx.files.internal("images/l6.png"));
        l7 = new Texture(Gdx.files.internal("images/l7.png"));
        l8 = new Texture(Gdx.files.internal("images/l8.png"));
        l9 = new Texture(Gdx.files.internal("images/l9.png"));
        l10 = new Texture(Gdx.files.internal("images/l10.png"));

        levels = new Texture[][]{{l1, l2, l3}, {l4, l5, l6}, {l7, l8, l9}};
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
        game.batch.draw(game.background,0,0);
        int len = levels.length;
        for(i=0;i<3;i++){
            for(j = 0; j < 3; j++){
                game.batch.draw(levels[i][j], (j + 1) * 120 - 32, 800 - (i + 1) * 200);
            }
        }
        game.batch.end();

        if (Gdx.input.isTouched()) {
            Vector3 tmp = new Vector3(Gdx.input.getX(),Gdx.input.getY(),0);
            for(i = 0;i<3;i++){
                for(j=0;j<3;j++){
                }
            }
            dispose();
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
        l1.dispose();
        l2.dispose();
        l3.dispose();
        l4.dispose();
        l5.dispose();
        l6.dispose();
        l7.dispose();
        l8.dispose();
        l9.dispose();
        l10.dispose();
    }
}
