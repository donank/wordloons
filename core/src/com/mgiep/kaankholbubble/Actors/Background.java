package com.mgiep.kaankholbubble.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;

public class Background extends Actor {

    private Texture texture;
    float actorX = 0, actorY = 0;
    public Background(){
        texture = new Texture(Gdx.files.internal("images/skybackground.png"));

    }

    @Override
    public void draw(Batch batch, float parentAlpha){
        batch.draw(texture,actorX,actorY);
    }
}
