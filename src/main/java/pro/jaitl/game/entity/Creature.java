package pro.jaitl.game.entity;

import java.util.List;

import pro.jaitl.game.map.Coordinate;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.map.path.CoordinateDesigionStrategy;
import pro.jaitl.game.map.path.Path;
import pro.jaitl.game.map.path.PathSearch;

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
        Coordinate myCoordinate = map.getCoordinate(this);
        PathSearch patchSearch = map.getPatchSearch();
        Path path = patchSearch.find(searchStrategy(map), myCoordinate);
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
        worldMap.remove(this);
        worldMap.add(newCoordinate, this);
    }

    private void eat(WorldMap map, Coordinate coordinate) {
        map.remove(coordinate);
        move(map, coordinate);
    }
}
