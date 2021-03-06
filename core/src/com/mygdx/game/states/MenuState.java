package com.mygdx.game.states;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.audio.Music;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public class MenuState extends State {

    private Texture background;
    private Music music;

    //TODO: Remove the button
    private Texture button;

    public MenuState(GameStateManager gsm) {
        super(gsm);

        music = Gdx.audio.newMusic(Gdx.files.internal("music/title-screen.mp3"));
        music.setLooping(true);
        music.play();

        background = new Texture(Gdx.files.internal("backgrounds/pokeman.png"));

        button = new Texture(Gdx.files.internal("buttons/start_up.png"));
    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {

    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
            batch.draw(background,0,0);
            batch.draw(button, 400 - button.getWidth()/2, 390);
        batch.end();
    }

    @Override
    public void dispose(){
        background.dispose();
        music.dispose();
    }
}
