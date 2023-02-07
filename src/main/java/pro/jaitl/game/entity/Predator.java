package pro.jaitl.game.entity;

import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.Params;
import pro.jaitl.game.params.PredatorParams;

public class Predator extends Creature {
    private final int strength;

    public Predator(PredatorParams params) {
        super("🐺", params.getMaxHealth(), params.getMoveCount());
        this.strength = params.getStrength();
    }

    @Override
    public void makeMove(WorldMap map, Params params) {

    }
}
