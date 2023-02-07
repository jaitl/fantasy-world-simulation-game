package pro.jaitl.game.entity;

import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.HerbivoreParams;
import pro.jaitl.game.params.Params;

public class Herbivore extends Creature {

    public Herbivore(HerbivoreParams params) {
        super("🐮", params.getMaxHealth(), params.getMoveCount());
    }

    @Override
    public void makeMove(WorldMap map, Params params) {

    }
}
