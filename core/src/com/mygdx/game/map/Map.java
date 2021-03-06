package com.mygdx.game.map;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

public class Map {

    private int mapWidth;
    private int mapHeight;
    private float tileWidth;
    private float tileHeight;

    private Vector2 startPosition;

    private Tile[][] map;

    public Map(char[][] data, int mapWidth, int mapHeight) {

        if (data == null) {
            throw new IllegalArgumentException("Map data has not been initialized");
        }

        this.mapWidth = mapWidth;
        this.mapHeight = mapHeight;
        this.tileWidth = (float)mapWidth/ (float) data.length;
        this.tileHeight = (float)mapHeight/ (float) data[0].length;
        this.map = new Tile[data.length][data[0].length];

        init(data);
    }

    private void init(char[][] data) {
        for (int width = 0; width < data.length; width++) {
            for (int height = 0; height < data[0].length; height++) {
                char character = data[width][height];
                switch (character) {
                    case 'w':
                        WallTile wall = new WallTile(new Vector2(tileWidth * width,tileHeight * height), tileWidth, tileHeight);
                        map[width][height] = wall;
                        break;
                    case 'r':
                        RoadTile road = new RoadTile(new Vector2(tileWidth * width,tileHeight*height), tileWidth, tileHeight);
                        map[width][height] = road;
                        break;
                    case 's':
                        RoadTile tile = new RoadTile(new Vector2(tileWidth * width,tileHeight*height), tileWidth, tileHeight);
                        map[width][height] = tile;
                        this.startPosition = new Vector2(width, height);
                        break;
                    default:
                        break;
                }
            }
        }
    }

    public void render(SpriteBatch batch) {
        for(Tile[] column : map) {
            for(Tile tile : column) {
                batch.draw(tile.getSprite(), tile.getPosition().x, tile.getPosition().y, tileWidth, tileHeight);
            }
        }
    }

    public void dispose() {
        for(Tile[] column : map) {
            for(Tile tile : column) {
                tile.dispose();
            }
        }
    }

    public Vector2 getStartPosition() {
        return startPosition;
    }

    public float getTileWidth() {
        return tileWidth;
    }

    public float getTileHeight() {
        return tileHeight;
    }

    public int getMapHeight() {
        return mapHeight;
    }

    public int getMapWidth() {
        return mapWidth;
    }

    public Tile[][] getMap() {
        return map;
    }

    public int getAmountOfTilesX(){
        return map.length;
    }

    public int getAmountOfTilesY(){
        return map[0].length;
    }
}
