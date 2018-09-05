package com.mygdx.game.states;

import characters.MovableEntity;
import characters.Pair;
import characters.PokéMan;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.PacMan;
import com.mygdx.game.map.Map;

public class PlayState extends State {

    private Map map;

    public static final float updateStepDelay = .3f;
    public static final float stepsPerTile = 10;
    private PokéMan mainCharacter;


    public PlayState(GameStateManager gsm) {
        super(gsm);
        camera.setToOrtho(false, 800, 800);

        //TODO: Create a level class which contains the Map, Characters, updateStepDelay(Later levels have can go faster),  and Diamonds etc.
        char[][] data = {
                {'w','w', 'w','w','w', 'w',},
                {'w','r', 'r','r','r', 'w'},
                {'r','r', 'r','r','r', 'w',},
                {'w','r', 'w','w','r', 'w'},
                {'w','r', 'r','r','r', 'w'}
        };

        map = new Map(data, PacMan.WIDTH, PacMan.HEIGHT);

        mainCharacter = new PokéMan(new Pair(1,3), MovableEntity.SOUTH, map);

    }

    @Override
    public void handleInput() {

    }

    @Override
    public void update(float dt) {
        mainCharacter.update(dt);
    }

    @Override
    public void render(SpriteBatch batch) {
        batch.begin();
            map.render(batch);
            mainCharacter.render(batch);
        batch.end();
    }

    @Override
    public void dispose(){
    }
}
