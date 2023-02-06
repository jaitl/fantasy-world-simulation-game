package pro.jaitl.game.entity;

import pro.jaitl.game.WorldMap;

public abstract class Creature extends Entity {
    private int health;
    private int moveCount;

    public abstract void makeMove(WorldMap map);
}
