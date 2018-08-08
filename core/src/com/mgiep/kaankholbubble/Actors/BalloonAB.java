package com.mgiep.kaankholbubble.Actors;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BalloonAB extends Actor {

    private Texture texture;
    float actorX = 0, actorY = 0;
    public boolean started = false;

    public BalloonAB(){
        texture = new Texture(Gdx.files.internal("images/balloon.png"));
        //actorX = -texture.getWidth();
        setBounds(actorX,actorY,texture.getWidth(),texture.getHeight());
        addListener(new InputListener(){
            public boolean touchDown (InputEvent event, float x, float y, int pointer, int button) {
                ((BalloonAB)event.getTarget()).started = true;
                return true;
            }
        });


    }

    @Override
    public void draw(Batch batch,float parentAlpha){
        batch.draw(texture,actorX,actorY);
    }

    @Override
    public void act(float delta){

    }
}
