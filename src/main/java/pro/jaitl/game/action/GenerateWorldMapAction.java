package pro.jaitl.game.action;

import java.util.List;
import java.util.function.Supplier;

import pro.jaitl.game.entity.Entity;
import pro.jaitl.game.entity.Grass;
import pro.jaitl.game.entity.Herbivore;
import pro.jaitl.game.entity.Predator;
import pro.jaitl.game.entity.Rock;
import pro.jaitl.game.entity.Tree;
import pro.jaitl.game.map.Coordinate;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.WorldSizeParams;
import pro.jaitl.game.params.Params;
import pro.jaitl.game.utils.RandomUtils;

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
        List<T> entities = map.getEntitiesByClass(clazz);

        // Проверяем процент живых существ, если он больше требуемого, то не добавляем новых
        if (!entities.isEmpty()) {
            return;
        }

        int generateCount = count - entities.size();

        for (int i = 0; i < generateCount; i += 1) {
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
