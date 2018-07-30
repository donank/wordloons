package com.mgiep.kaankholbubble.Screens;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mgiep.kaankholbubble.KaankholBubble;

import java.awt.Rectangle;
import java.util.Iterator;

public class GameScreen implements Screen {

    final KaankholBubble game;
    private Texture loon, loonA, loonB;
    private Sound s1, s2, s3, s4, s5;
    private OrthographicCamera camera;
    private Rectangle target;
    private Rectangle balloon;
    private Array<Rectangle> balloons;
    private int score;
    private Vector3 targetPos;
    private long lastFakeLoonSpawntime, lastTargetLoonSpawnTime;

    public GameScreen(KaankholBubble game) {
        this.game = game;

        loon = new Texture(Gdx.files.internal("images/balloon.png"));
        loonA = new Texture(Gdx.files.internal("images/aballoon.png"));
        loonB = new Texture(Gdx.files.internal("images/bballoon.png"));
        balloons = new Array<Rectangle>();
        spawnFakeLoons();
        spawnTargetLoon();

        camera = new OrthographicCamera();
        camera.setToOrtho(false, 480, 800);
    }


    @Override
    public void show() {

    }

    @Override
    public void render(float delta) {
        Gdx.gl.glClearColor(0, 0, 0, 1);
        Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

        camera.update();
        game.batch.setProjectionMatrix(camera.combined);


        game.batch.begin();
        for(Rectangle balloon: balloons){
            game.batch.draw(loonB, balloon.x, balloon.y);
        }
        for(Rectangle balloon: balloons){
            game.batch.draw(loonA, balloon.x, balloon.y);
        }
        for(Rectangle balloon: balloons){
            game.batch.draw(loon, balloon.x, balloon.y);
        }
        game.batch.end();


        if (Gdx.input.isTouched()) {
            Vector3 touchPos = new Vector3();
            touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
            camera.unproject(touchPos);
            if(touchPos == targetPos){

                score++;
            }
        }

        if(TimeUtils.nanoTime() - lastFakeLoonSpawntime > 1000000000) spawnFakeLoons();


        for(Iterator<Rectangle> iter = balloons.iterator(); iter.hasNext();){
            Rectangle loon = iter.next();
            loon.y += 200 * Gdx.graphics.getDeltaTime();
            if(loon.y > 800)iter.remove();

        }

    }

    private  void spawnFakeLoons(){
        Rectangle fakeLoon = new Rectangle();
        fakeLoon.x = MathUtils.random(0, 480-32);
        fakeLoon.y = 0;
        fakeLoon.width = 32;
        fakeLoon.height = 32;
        balloons.add(fakeLoon);
        lastFakeLoonSpawntime = TimeUtils.nanoTime();
    }

    private void spawnTargetLoon(){
        Rectangle targetLoon = new Rectangle();
        targetLoon.x = MathUtils.random(0, 480-32);
        targetLoon.y = 0;
        targetLoon.width = 32;
        targetLoon.height = 32;
        balloons.add(targetLoon);
        lastTargetLoonSpawnTime = TimeUtils.nanoTime();
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
        loon.dispose();
        loonA.dispose();
        loonB.dispose();
        //s1.dispose();
        //s2.dispose();
        //s3.dispose();
        //s4.dispose();
        //s5.dispose();
    }
}
