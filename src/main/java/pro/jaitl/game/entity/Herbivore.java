package pro.jaitl.game.entity;

import java.util.List;

import pro.jaitl.game.map.Coordinate;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.map.path.CoordinateDesigionStrategy;
import pro.jaitl.game.map.path.Desigion;
import pro.jaitl.game.map.path.Path;
import pro.jaitl.game.map.path.PathSearch;
import pro.jaitl.game.params.HerbivoreParams;

public class Herbivore extends Creature {
    private final HerbivoreParams params;

    public Herbivore(HerbivoreParams params) {
        super("🐮", params.getMaxHealth(), params.getMoveCount());
        this.params = params;
    }

    @Override
    public void makeMove(WorldMap map) {
        Coordinate myCoordinate = map.getCoordinate(this);
        PathSearch patchSearch = map.getPatchSearch();
        Path path = patchSearch.find(searchStrategy(map), myCoordinate);
        List<Coordinate> coordinates = path.toList();

        for (int i = 0; i < getMoveCount(); i += 1) {
            if (coordinates.size() <= i) {
                break;
            }
            
            Coordinate coordinate = coordinates.get(i);
            Entity entity = map.getEntity(coordinate);

            if (entity == null) {
                moveCreature(map, coordinate);
            }
            if (entity instanceof Grass) {
                eat(map, coordinate);
                break;
            }
        }
    }

    private void eat(WorldMap map, Coordinate coordinate) {
        map.remove(coordinate);
        moveCreature(map, coordinate);
        setHealth(params.getMaxHealth());
    }

    private CoordinateDesigionStrategy searchStrategy(WorldMap map) {
        return coordinate -> {
            Entity entity = map.getEntity(coordinate);

            if (entity == null) {
                return Desigion.neutral;
            }
            if (entity instanceof Grass) {
                return Desigion.target;
            }

            return Desigion.obstacle;
        };
    }
}
