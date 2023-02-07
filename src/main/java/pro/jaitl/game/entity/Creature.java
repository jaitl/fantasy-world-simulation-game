package pro.jaitl.game.entity;

import pro.jaitl.game.Params;
import pro.jaitl.game.WorldMap;

public abstract class Creature extends Entity {
    private int health;
    private int moveCount;

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getMoveCount() {
        return moveCount;
    }

    public void setMoveCount(int moveCount) {
        this.moveCount = moveCount;
    }

    public Creature(String name, int health, int moveCount) {
        super(name);
        this.health = health;
        this.moveCount = moveCount;
    }

    public abstract void makeMove(WorldMap map, Params params);
}
