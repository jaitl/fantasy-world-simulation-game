package pro.jaitl.game.entity;

import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.PredatorParams;

public class Predator extends Creature {
    private final int strength;
    private final PredatorParams params;

    public Predator(PredatorParams params) {
        super("🐺", params.getMaxHealth(), params.getMoveCount());
        this.strength = params.getStrength();
        this.params = params;
    }

    @Override
    public void makeMove(WorldMap map) {
            
    }
}
