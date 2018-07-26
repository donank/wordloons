package com.mgiep.kaankholbubble;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;

import org.w3c.dom.css.Rect;

import java.awt.Rectangle;
import java.util.Iterator;

public class KaankholBubble extends ApplicationAdapter {
	private SpriteBatch batch;
	private Texture loon, loonA, loonB;
	private Sound s1, s2, s3, s4, s5;
	private OrthographicCamera camera;
	private Rectangle target;
	private Array<Rectangle> balloons;
	private int score;
	private Vector3 targetPos;
	private long lastFakeLoonSpawntime, lastTargetLoonSpawnTime;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		loon = new Texture(Gdx.files.internal("/images/balloon.jpg"));
		loonA = new Texture(Gdx.files.internal("/images/aballoon.jpg"));
		loonB = new Texture(Gdx.files.internal("/images/bballoon.jpg"));
		s1 = new Gdx.audio.newSound(Gdx.files.internal(""));
		s2 = new Gdx.audio.newSound(Gdx.files.internal(""));
		s3 = new Gdx.audio.newSound(Gdx.files.internal(""));
		s4 = new Gdx.audio.newSound(Gdx.files.internal(""));
		s5 = new Gdx.audio.newSound(Gdx.files.internal(""));
		balloons = new Array<Rectangle>();
		spawnFakeLoons();
		spawnTargetLoon();
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		camera.update();
		batch.setProjectionMatrix(camera.combined);


		batch.begin();

		if (Gdx.input.isTouched()) {
			Vector3 touchPos = new Vector3();
			touchPos.set(Gdx.input.getX(), Gdx.input.getY(), 0);
			camera.unproject(touchPos);
			if(touchPos == targetPos){
				score++;
			}
		}

		if(TimeUtils.nanoTime() - lastFakeLoonSpawntime > 1000000000) spawnFakeLoons();
		spawnTargetLoon();

		for(Iterator<Rectangle> iter = balloons.iterator(); iter.hasNext();){
			Rectangle loon = iter.next();
			loon.y += 200 * Gdx.graphics.getDeltaTime();
			if(loon.y > 800)iter.remove();

		}
		batch.end();
	}

	private  void spawnFakeLoons(){
		Rectangle fakeLoon = new Rectangle();
		fakeLoon.x = MathUtils.random(0, 480-128);
		fakeLoon.y = 0;
		fakeLoon.width = 128;
		fakeLoon.height = 128;
	}

	private void spawnTargetLoon(){
		Rectangle targetLoon = new Rectangle();
		targetLoon.x = MathUtils.random(0, 480-128);
		targetLoon.y = 0;
		targetLoon.width = 128;
		targetLoon.height = 128;
	}

	@Override
	public void dispose () {
		loon.dispose();
		loonA.dispose();
		loonB.dispose();
		s1.dispose();
		s2.dispose();
		s3.dispose();
		s4.dispose();
		s5.dispose();
		batch.dispose();
		img.dispose();
	}
}
