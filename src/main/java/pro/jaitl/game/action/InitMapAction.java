package pro.jaitl.game.action;

import java.util.function.Supplier;

import pro.jaitl.game.entity.Entity;
import pro.jaitl.game.entity.Grass;
import pro.jaitl.game.entity.Herbivore;
import pro.jaitl.game.entity.Predator;
import pro.jaitl.game.entity.Tree;
import pro.jaitl.game.map.Coordinate;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.InitParams;
import pro.jaitl.game.params.Params;
import pro.jaitl.game.utils.RandomUtils;

public class InitMapAction implements Action {

    @Override
    public void doAction(WorldMap map, Params params) {
        InitParams initParams = params.getInitParams();
        generateEntities(initParams.getGrossCount(), map, () -> new Grass());
        generateEntities(initParams.getTreeCount(), map, () -> new Tree());
        generateEntities(initParams.getHerbivoreCount(), map, () -> new Herbivore(params.getHerbivoreParams()));
        generateEntities(initParams.getPredatorCount(), map, () -> new Predator(params.getPredatorParams()));
    }

    private void generateEntities(int count, WorldMap map, Supplier<Entity> supplier) {
        for (int i = 0; i < count; i += 1) {
            Coordinate coordinate = randomCoordinate(map);
            Entity entity = supplier.get();
            map.add(coordinate, entity);
        }
    }

    private Coordinate randomCoordinate(WorldMap map) {
        while(true) {
            Coordinate coordinate = RandomUtils.randomCoordinate(map.getSize());
            if (!map.hasCoorditate(coordinate)) {
                return coordinate;
            }
        }
    }
}
