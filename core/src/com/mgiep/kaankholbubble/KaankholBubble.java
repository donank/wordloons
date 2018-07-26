package com.mgiep.kaankholbubble;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.utils.Array;

import java.awt.Rectangle;

public class KaankholBubble extends ApplicationAdapter {
	SpriteBatch batch;
	Texture img;
	private Texture loon, loonA, loonB;
	private Sound s1, s2, s3, s4, s5;
	private OrthographicCamera camera;
	private Rectangle target;
	private Array<Rectangle> balloons;
	
	@Override
	public void create () {
		batch = new SpriteBatch();
		img = new Texture("badlogic.jpg");
		loon = new Texture(Gdx.files.internal("/images/balloon.jpg"));
		loonA = new Texture(Gdx.files.internal("/images/aballoon.jpg"));
		loonB = new Texture(Gdx.files.internal("/images/bballoon.jpg"));
		s1 = new Gdx.audio.newSound(Gdx.files.internal(""));
		s2 = new Gdx.audio.newSound(Gdx.files.internal(""));
		s3 = new Gdx.audio.newSound(Gdx.files.internal(""));
		s4 = new Gdx.audio.newSound(Gdx.files.internal(""));
		s5 = new Gdx.audio.newSound(Gdx.files.internal(""));
		camera = new OrthographicCamera();
		camera.setToOrtho(false, 480, 800);
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		batch.begin();
		batch.draw(img, 0, 0);
		batch.end();
	}
	
	@Override
	public void dispose () {
		bubble.dispose();
		s1.dispose();
		s2.dispose();
		s3.dispose();
		s4.dispose();
		s5.dispose();
		batch.dispose();
		img.dispose();
	}
}
