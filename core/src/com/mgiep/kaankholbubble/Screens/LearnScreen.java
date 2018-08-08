package com.mgiep.kaankholbubble.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.Touchable;
import com.mgiep.kaankholbubble.Actors.Background;
import com.mgiep.kaankholbubble.Actors.BalloonA;
import com.mgiep.kaankholbubble.Actors.BalloonAB;
import com.mgiep.kaankholbubble.Actors.BalloonB;
import com.mgiep.kaankholbubble.KaankholBubble;

public class LearnScreen implements Screen {

    final KaankholBubble game;
    OrthographicCamera camera;

    private Stage stage;

    public LearnScreen(KaankholBubble game){
        this.game = game;
        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);

        stage = new Stage();
        Gdx.input.setInputProcessor(stage);

        Background background = new Background();
        stage.addActor(background);

        BalloonA loonA = new BalloonA();
        loonA.setTouchable(Touchable.enabled);
        stage.addActor(loonA);

        BalloonB loonB = new BalloonB();
        loonB.setTouchable(Touchable.enabled);
        stage.addActor(loonB);

        BalloonAB loonAB = new BalloonAB();
        loonAB.setTouchable(Touchable.enabled);
        stage.addActor(loonAB);
    }

    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
        stage.act(Gdx.graphics.getDeltaTime());
        stage.draw();
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

    }
}
