package pro.jaitl.game.entity;

import java.util.List;

import pro.jaitl.game.map.Coordinate;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.map.path.CoordinateDesigionStrategy;
import pro.jaitl.game.map.path.Path;
import pro.jaitl.game.map.path.PathSearchAlg;

public abstract class Creature extends Entity {

    public Creature(String name) {
        super(name);
    }

    protected abstract CoordinateDesigionStrategy searchStrategy(WorldMap map);
    protected abstract Reaction reactionOnEntity(Entity entity);

    protected enum Reaction {
        move,
        eat;
    }

    public void makeMove(WorldMap map) {
        PathSearchAlg patchSearch = map.getPatchSearchAlg();
        Path path = patchSearch.find(searchStrategy(map), getCoordinate());
        List<Coordinate> coordinates = path.toList();

        if (coordinates.isEmpty()) {
            return;
        }

        Coordinate coordinate = coordinates.get(0);
        Entity entity = map.getEntity(coordinate);

        switch(reactionOnEntity(entity)) {
            case move:
                move(map, coordinate);
                break;
            case eat:
                eat(map, coordinate);
                break;
        }
    }

    private void move(WorldMap worldMap, Coordinate newCoordinate) {
        worldMap.move(this, newCoordinate);
    }

    private void eat(WorldMap map, Coordinate coordinate) {
        map.remove(coordinate);
        move(map, coordinate);
    }
}
