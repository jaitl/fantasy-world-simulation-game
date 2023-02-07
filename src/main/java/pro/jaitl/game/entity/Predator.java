package pro.jaitl.game.entity;

import pro.jaitl.game.WorldMap;

public class Predator extends Creature {
    private final int strength;

    public Predator(String name, int health, int moveCount, int strength) {
        super(name, health, moveCount);
        this.strength = strength;
    }

    @Override
    public void makeMove(WorldMap map) {

    }
}
