package com.mygdx.game.map;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.math.Vector2;

public interface Tile {
    Vector2 getPosition();
    Sprite getSprite();
    void dispose();
}
