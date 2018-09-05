package com.mygdx.game.map;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public class WallTile implements Tile{
    private Sprite sprite;
    private Vector2 position;

    public WallTile(Vector2 position) {
        this.position = position;
        sprite = new Sprite(new Texture(Gdx.files.internal("tiles/block.png")));
    }

    WallTile(Vector2 position, float width, float height) {
        this.position = position;
        sprite = new Sprite(new Texture(Gdx.files.internal("tiles/block.png")));
        sprite.setSize(width,height);
    }

    @Override
    public Vector2 getPosition() {
        return position;
    }

    @Override
    public Sprite getSprite() {
        return sprite;
    }

    @Override
    public void dispose() {
        sprite.getTexture().dispose();
    }
}
