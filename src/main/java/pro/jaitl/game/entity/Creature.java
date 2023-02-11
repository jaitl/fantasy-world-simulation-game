package pro.jaitl.game.entity;

import java.util.List;

import pro.jaitl.game.map.Coordinate;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.map.path.CoordinateDesigionStrategy;
import pro.jaitl.game.map.path.Path;
import pro.jaitl.game.map.path.PathSearchAlg;

public abstract class Creature extends Entity implements Comparable<Creature> {
    // Приоритет при ходе, животное с наименьшим приоритетом ходит первым.
    private final int priority;

    public int getPriority() {
        return priority;
    }

    public Creature(String name, int priority) {
        super(name);
        this.priority = priority;
    }

    protected abstract CoordinateDesigionStrategy searchStrategy(WorldMap map);
    protected abstract Reaction reactionOnEntity(Entity entity);

    protected enum Reaction {
        move,
        eat;
    }

    @Override
    public int compareTo(Creature arg0) {
        return Integer.compare(priority, arg0.getPriority());
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
