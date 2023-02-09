package pro.jaitl.game.map;

import java.util.HashMap;
import java.util.Map;

import pro.jaitl.game.entity.Entity;
import pro.jaitl.game.map.path.PathSearch;
import pro.jaitl.game.map.path.PathSearchBfsImpl;

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
        if (coordinates.containsKey(coordinate) || entities.containsKey(entity)) {
            throw new RuntimeException(String.format("already exists: %s, %s", coordinate, entity));
        }
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

    public Entity getEntity(Coordinate coordinate) {
        return coordinates.get(coordinate);
    }

    public Coordinate getCoordinate(Entity entity) {
        return entities.get(entity);
    }

    public PathSearch getPatchSearch() {
        return new PathSearchBfsImpl(size);
    }

    @Override
    public String toString() {
        final String emptySymbol = "🟫";
        StringBuilder builder = new StringBuilder();
        for (int x = 0; x < size; x += 1) {
            for (int y = 0; y < size; y += 1) {
                Entity entity = coordinates.get(new Coordinate(x, y));
                if (entity != null) {
                    builder.append(entity.getName());
                } else {
                    builder.append(emptySymbol);
                }
            }
            builder.append("\n\r");
        }
        return builder.toString();
    }
}
