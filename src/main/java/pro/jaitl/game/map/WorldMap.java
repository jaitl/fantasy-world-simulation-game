package pro.jaitl.game.map;

import java.util.HashMap;
import java.util.Map;

import pro.jaitl.game.entity.Entity;

public class WorldMap {
    private final int size;

    private final Map<Entity, Coordinate> entities = new HashMap<>();
    private final Map<Coordinate, Entity> coordinates = new HashMap<>();

    public WorldMap(int size) {
        this.size = size;
    }

    public int getSize() {
        return size;
    }

    public boolean hasCoorditate(Coordinate coordinate) {
        return coordinates.containsKey(coordinate);
    }

    public void add(Coordinate coordinate, Entity entity) {
        entities.put(entity, coordinate);
        coordinates.put(coordinate, entity);
    }

    public void remove(Coordinate coordinate) {
        Entity entity = coordinates.remove(coordinate);
        entities.remove(entity);
    }

    public void remove(Entity entity) {
        Coordinate coordinate = entities.remove(entity);
        coordinates.remove(coordinate);
    }
}
