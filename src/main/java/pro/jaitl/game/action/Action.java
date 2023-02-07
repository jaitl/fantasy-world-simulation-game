package pro.jaitl.game.action;

import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.Params;

public interface Action {
    void doAction(WorldMap map, Params params);
}
