package pro.jaitl.game.entity;

import pro.jaitl.game.map.Coordinate;

public abstract class Entity {
    private final String name;
    private Coordinate coordinate;

    public String getName() {
        return name;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public Entity(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return this.getClass().getName() + " [name=" + name + "]";
    }
}
