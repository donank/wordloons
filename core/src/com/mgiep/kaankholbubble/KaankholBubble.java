    package com.mgiep.kaankholbubble;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mgiep.kaankholbubble.Screens.MainMenuScreen;

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
