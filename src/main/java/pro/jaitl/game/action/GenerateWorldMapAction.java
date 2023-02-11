package pro.jaitl.game.action;

import java.util.List;
import java.util.function.Supplier;

import pro.jaitl.game.entity.Entity;
import pro.jaitl.game.entity.Grass;
import pro.jaitl.game.entity.Herbivore;
import pro.jaitl.game.entity.Predator;
import pro.jaitl.game.entity.Rock;
import pro.jaitl.game.entity.Tree;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.Params;
import pro.jaitl.game.params.WorldSizeParams;

public class GenerateWorldMapAction implements Action {

    @Override
    public void doAction(WorldMap map, Params params) {
        WorldSizeParams worldSizeParams = params.getWorldSizeParams();

        generateEntities(worldSizeParams.getGrossCount(), map, () -> new Grass(), Grass.class);
        generateEntities(worldSizeParams.getTreeCount(), map, () -> new Tree(), Tree.class);
        generateEntities(worldSizeParams.getRockCount(), map, () -> new Rock(), Rock.class);
        generateEntities(worldSizeParams.getHerbivoreCount(), map, () -> new Herbivore(), Herbivore.class);
        generateEntities(worldSizeParams.getPredatorCount(), map, () -> new Predator(), Predator.class);
    }

    private <T extends Entity> void generateEntities(int count, WorldMap map, Supplier<T> supplier, Class<T> clazz) {
        List<T> entities = map.findEntitiesByClass(clazz);

        // Проверяет есть ли сущности такого типа на карте, если нет, то добавляем
        if (!entities.isEmpty()) {
            return;
        }

        for (int i = 0; i < count; i += 1) {
            Entity entity = supplier.get();
            map.putOnRandomCoordinate(entity);;
        }
    }
}
