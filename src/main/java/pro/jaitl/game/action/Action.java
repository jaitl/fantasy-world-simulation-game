package pro.jaitl.game.action;

import pro.jaitl.game.Params;
import pro.jaitl.game.WorldMap;

public interface Action {
    void doAction(WorldMap map, Params params);
}
