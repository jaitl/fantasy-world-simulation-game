package pro.jaitl.game.map.path;

import pro.jaitl.game.map.Coordinate;

/*
 * Интерфейс алгоритма поиска пути
 */
public abstract class PathSearch {
    protected final int mapSize;

    public PathSearch(int mapSize) {
        this.mapSize = mapSize;
    }

    /*
     * Ищет путь на карте по переданной страгерии.
     * Возвращает список из координат с путем до цели.
     */
    public abstract Path find(CoordinateDesigionStrategy strategy, Coordinate startCoordinate);
}
