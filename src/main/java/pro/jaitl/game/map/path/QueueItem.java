package pro.jaitl.game.map.path;

import pro.jaitl.game.map.Coordinate;

/*
 * Структура для хранения координаты и пути до координаты.
 */
public class QueueItem {
    private final Coordinate coordinate;
    private final Path path;

    public QueueItem(Coordinate coordinate, Path path) {
        this.coordinate = coordinate;
        this.path = path;
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Path getPath() {
        return path;
    }
}
