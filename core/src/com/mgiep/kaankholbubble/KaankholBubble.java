    package com.mgiep.kaankholbubble;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.MathUtils;
import com.badlogic.gdx.math.Vector3;
import com.badlogic.gdx.utils.Array;
import com.badlogic.gdx.utils.TimeUtils;
import com.mgiep.kaankholbubble.Screens.MainMenuScreen;

import java.awt.Rectangle;
import java.util.Iterator;

public class KaankholBubble extends Game {
	public SpriteBatch batch;
	public Texture background;

    @Override
	public void create () {
		batch = new SpriteBatch();
		this.setScreen(new MainMenuScreen(this));
		background = new Texture(Gdx.files.internal("images/skybackground.png"));
	}

	@Override
	public void render () {
        super.render();
	}



	@Override
	public void dispose () {
		batch.dispose();
		background.dispose();
	}
}
