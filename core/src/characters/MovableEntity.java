package characters;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;
import com.mygdx.game.map.Map;
import com.mygdx.game.states.PlayState;

public abstract class MovableEntity {

    public static final int NORTH = 1;
    public static final int EAST = 2;
    public static final int SOUTH = 3;
    public static final int WEST = 4;

    // Actual position
    private Vector2 position;


    private Pair currentPosition;
    private Pair nextPosition;

    private int currentDirection;
    private int nextDirection;
    private Map map;

    private float deltaTime;

    public MovableEntity(Pair startPosition, int startDirection, Map map){
        this.currentPosition = startPosition;
        switch (startDirection) {
            case NORTH:
                if(!(currentPosition.getY() >= map.getTileHeight())) {
                    nextPosition  = new Pair(currentPosition.getX(), currentPosition.getY() + 1);
                } else {
                    nextPosition = currentPosition;
                }
                break;
            case EAST:
                if(!(currentPosition.getX() >= map.getAmountOfTilesX())) {
                    nextPosition  = new Pair(currentPosition.getX() +1, currentPosition.getY());
                } else {
                    nextPosition = currentPosition;
                }
                break;
            case SOUTH:
                if(!(currentPosition.getY() <= 0)) {
                    nextPosition  = new Pair(currentPosition.getX(), (currentPosition.getY() -1));
                } else {
                    nextPosition = currentPosition;
                }
                break;
            case WEST:
                if(!(currentPosition.getX() <= 0)) {
                    nextPosition  = new Pair(currentPosition.getX() -1 , currentPosition.getY());
                } else {
                    nextPosition = currentPosition;
                }
                break;
            default:
                break;
        }

        this.position = new Vector2(startPosition.getX() * map.getTileWidth(), startPosition.getY() * map.getTileHeight());
        this.map = map;

        currentDirection = nextDirection = startDirection;
    }

    public void updatePosition(float dt) {
        //TODO: This dt holds for all units and can be moved to the playState or a level class or something
        deltaTime += dt;
        if(deltaTime > PlayState.updateStepDelay) {
            deltaTime = 0;

            switch (currentDirection) {
                case NORTH:
                    float newYNorth = position.y + (map.getTileHeight()/PlayState.stepsPerTile) * getSpeed();

                    if (newYNorth >= nextPosition.getY() * map.getTileHeight()) {
                        newYNorth = nextPosition.getY() * map.getTileHeight();
                        position.y = newYNorth;

                        // Determine new nextPosition;
                        currentPosition = nextPosition;
                        currentDirection = nextDirection;
                        getNextPosition();
                    }
                    else {
                        position.y = newYNorth;
                    }
                    break;
                case EAST:
                        float newXEast = position.x + (map.getTileWidth()/PlayState.stepsPerTile) * getSpeed();

                        if (newXEast >= nextPosition.getX() * map.getTileWidth()) {
                            newXEast = nextPosition.getX() * map.getTileWidth();
                            position.x = newXEast;

                            // Determine new nextPosition;
                            currentPosition = nextPosition;
                            currentDirection = nextDirection;
                            getNextPosition();
                        }
                        else {
                            position.x = newXEast;
                        }
                    break;
                case SOUTH:
                    float newY = position.y - (map.getTileHeight()/PlayState.stepsPerTile) * getSpeed();

                    if (newY <= nextPosition.getY() * map.getTileHeight()) {
                        newY = nextPosition.getY() * map.getTileHeight();
                        position.y = newY;

                        // Determine new nextPosition;
                        currentPosition = nextPosition;
                        currentDirection = nextDirection;
                        getNextPosition();
                    }
                    else {
                        position.y = newY;
                    }
                    break;
                case WEST:
                    float newX = position.x - (map.getTileWidth()/PlayState.stepsPerTile) * getSpeed();

                    if (newX <= nextPosition.getX() * map.getTileWidth()) {
                        newX = nextPosition.getX() * map.getTileWidth();
                        position.x = newX;

                        // Determine new nextPosition;
                        currentPosition = nextPosition;
                        currentDirection = nextDirection;
                        getNextPosition();
                    }
                    else {
                        position.x = newX;
                    }
                    break;
                default:
                    break;
            }
        }
    }

    private void getNextPosition() {
        switch (currentDirection) {
            case NORTH:
                if(!(currentPosition.getY() >= map.getAmountOfTilesY() -1)) {
                    nextPosition.setY(nextPosition.getY() + 1);
                } else {
                    nextPosition = currentPosition;
                }
            default:
                break;
            case EAST:
                if(!(currentPosition.getX() >= map.getAmountOfTilesX() -1)) {
                    nextPosition.setX(currentPosition.getX() + 1);
                } else {
                    nextPosition = currentPosition;
                }
                break;
            case SOUTH:
                if(!(currentPosition.getY() <= 0)) {
                    nextPosition  = new Pair(currentPosition.getX(), (currentPosition.getY() -1));
                } else {
                    nextPosition = currentPosition;
                }

                break;
            case WEST:
                if(!(currentPosition.getX() <= 0)) {
                    nextPosition.setX(currentPosition.getX() - 1);
                } else {
                    nextPosition = currentPosition;
                }
                break;
        }
    }

    private static float round (float value, int precision) {
        int scale = (int) Math.pow(10, precision);
        return (float) Math.round(value * scale) / scale;
    }

    public Vector2 getPosition() {
        return position;
    }

    public Map getMap() {
        return map;
    }

    public abstract void update(float dt);
    public abstract void render(SpriteBatch batch);
    public abstract void dispose();
    public abstract Sprite getSprite();
    public abstract float getSpeed();
}

