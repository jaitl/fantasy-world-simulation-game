package pro.jaitl.game.map;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import pro.jaitl.game.entity.Creature;
import pro.jaitl.game.entity.Entity;
import pro.jaitl.game.map.path.PathSearchAlg;
import pro.jaitl.game.map.path.PathSearchBfsImpl;
import pro.jaitl.game.utils.RandomUtils;

public class WorldMap {
    private final int size;

    private final Map<Coordinate, Entity> coordinates = new HashMap<>();

    public WorldMap(int size) {
        this.size = size;
    }

    public void putOnRandomCoordinate(Entity entity) {
        Coordinate coordinate = randomCoordinate();
        entity.setCoordinate(coordinate);
        coordinates.put(coordinate, entity);
    }

    public void remove(Coordinate coordinate) {
        Entity entity = coordinates.remove(coordinate);
        entity.setCoordinate(null);
    }

    public void remove(Entity entity) {
        coordinates.remove(entity.getCoordinate());
        entity.setCoordinate(null);
    }

    public void move(Entity entity, Coordinate newCoordinate) {
        if (coordinates.containsKey(newCoordinate)) {
            throw new RuntimeException("Coordinate already exists: " + newCoordinate);
        }
        remove(entity);
        entity.setCoordinate(newCoordinate);
        coordinates.put(newCoordinate, entity);
    }

    public Entity getEntity(Coordinate coordinate) {
        return coordinates.get(coordinate);
    }

    /*
     * Возвращает живых существ
     */
    public List<Creature> getCreatures() {
        List<Creature> creatures = new ArrayList<>();

        for (Entity entity : coordinates.values()) {
            if (entity instanceof Creature) {
                creatures.add((Creature) entity);
            }
        }

        return creatures;
    }

    /*
     * Находит список сущности по типу класса
     */
    public <T extends Entity> List<T> findEntitiesByClass(Class<T> clazz) {
        List<T> result = new ArrayList<>();

        for (Entity entity : coordinates.values()) {
            if (clazz.equals(entity.getClass())) {
                result.add((T) entity);
            }
        }

        return result;
    }

    /*
     * Возвращает алгоритм поиска пути
     */
    public PathSearchAlg getPatchSearchAlg() {
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

    /*
     * Генерирует случайную незанятую координату.
     * При генерации проверяет нет ли такой координаты на карте.
     */
    private Coordinate randomCoordinate() {
        while(true) {
            Coordinate coordinate = RandomUtils.randomCoordinate(size);
            if (!coordinates.containsKey(coordinate)) {
                return coordinate;
            }
        }
    }
}
