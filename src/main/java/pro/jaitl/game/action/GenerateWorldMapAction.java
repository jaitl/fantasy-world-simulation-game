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

        float alivePersent = worldSizeParams.getAlivePersent();

        generateEntities(worldSizeParams.getGrossCount(), alivePersent, map, () -> new Grass(), Grass.class);
        generateEntities(worldSizeParams.getTreeCount(), alivePersent, map, () -> new Tree(), Tree.class);
        generateEntities(worldSizeParams.getRockCount(), alivePersent, map, () -> new Rock(), Rock.class);
        generateEntities(worldSizeParams.getHerbivoreCount(), alivePersent, map, () -> new Herbivore(params.getHerbivoreParams()), Herbivore.class);
        generateEntities(worldSizeParams.getPredatorCount(), alivePersent, map, () -> new Predator(params.getPredatorParams()), Predator.class);
    }

    private <T extends Entity> void generateEntities(int count, float alivePersent, WorldMap map, Supplier<T> supplier, Class<T> clazz) {
        List<T> entities = map.getByClass(clazz);

        // Проверяем процент живых существ, если он больше требуемого, то не добавляем новых
        if (count * alivePersent < entities.size()) {
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
