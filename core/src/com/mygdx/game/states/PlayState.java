package com.mygdx.game.states;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.PacMan;
import com.mygdx.game.map.Map;

public class PlayState extends State {

    private Map map;

    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 800);


        char[][] data = {
                {'w','w', 'w','w','w', 'w',},
                {'w','r', 'r','r','r', 'w'},
                {'r','r', 'r','r','r', 'w',},
                {'w','r', 'w','w','r', 'w'},
                {'w','r', 'r','r','r', 'w'},
                {'w','w', 'w','w','w', 'w'}
        };

        map = new Map(data, PacMan.WIDTH, PacMan.HEIGHT);
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
            map.render(batch);
        batch.end();
    }

    @Override
    public void dispose(){
    }
}
