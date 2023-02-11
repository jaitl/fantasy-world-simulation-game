package pro.jaitl.game.action;

import java.util.List;

import pro.jaitl.game.entity.Creature;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.Params;

public class MakeMoveAction implements Action {

    @Override
    public void doAction(WorldMap map, Params params) {
        List<Creature> creatures = map.getCreatures();
        for (Creature creature : creatures) {
            // проверяем есть ли такое животное на карте, возможно его уже съели...
            if (creature.getCoordinate() != null) {
                creature.makeMove(map);
            }
        }
    }
    
}
