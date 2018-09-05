package characters;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.mygdx.game.map.Map;

public class PokéMan extends MovableEntity {

    private Sprite sprite;
    private float speed;

    public PokéMan(Pair startPosition, int startDirection, Map map) {
        super(startPosition, startDirection, map);

        sprite = new Sprite(new Texture(Gdx.files.internal("characters/pacman.png")));
        speed = 2;
    }

    @Override
    public  float getSpeed() {
        return speed;
    }

    public void update(float dt) {
        updatePosition(dt);
    }

    public void render(SpriteBatch batch){
        batch.draw(sprite, getPosition().x, getPosition().y, getMap().getTileWidth(), getMap().getTileHeight());
    }

    public void dispose(){

    }

    public Sprite getSprite(){
        return sprite;
    }
}
