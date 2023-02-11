package pro.jaitl.game.map.path;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

import pro.jaitl.game.map.Coordinate;

/*
 * Реализация алгоритма поиска пути на основе алгоритма BFS.
 */
public class PathSearchBfsImpl extends PathSearchAlg {

    public PathSearchBfsImpl(int mapSize) {
        super(mapSize);
    }

    @Override
    public Path find(CoordinateDesigionStrategy strategy, Coordinate startCoordinate) {
        Set<Coordinate> visited = new HashSet<>();
        Queue<QueueItem> queue = new LinkedList<>();
        queue.add(new QueueItem(startCoordinate, null));

        while(!queue.isEmpty()) {
            QueueItem curentItem = queue.poll();
            List<Coordinate> coordinatesAround = findAround(curentItem.getCoordinate());
            for (Coordinate coordinate : coordinatesAround) {
                if (visited.contains(coordinate)) {
                    continue;
                }
                Path path = new Path(coordinate, curentItem.getPath());
                QueueItem item = new QueueItem(coordinate, path);
                switch(strategy.analize(coordinate)) {
                    case neutral:
                        // если по координате ничего не находится, то просто проходим через нее.
                        queue.add(item);
                        visited.add(coordinate);
                        break;
                    case obstacle:
                        // если обнаружено препядствие, то по этому пути не идем
                        visited.add(coordinate);
                        break;
                    case target:
                        // если целевая координата найдена, то возвращает путь до нее;
                        return path;
                }
            }
        }

        // Путь до желаемой цели ненайден
        return Path.empty();
    }

    /*
     * Обходит координату вокруг по часовой стрелке и ищет доступные вершины для посещения
     */
    private List<Coordinate> findAround(Coordinate coordinate) {
        List<Coordinate> result = new ArrayList<>();

        int x = coordinate.getX();
        int y = coordinate.getY();

        if (y + 1 < mapSize) {
            result.add(new Coordinate(x, y + 1));
        }
        if (x + 1 < mapSize && y + 1 < mapSize) {
            result.add(new Coordinate(x + 1, y + 1));
        }
        if (x + 1 < mapSize) {
            result.add(new Coordinate(x + 1, y));
        }
        if (x + 1 < mapSize && y - 1 >= 0) {
            result.add(new Coordinate(x + 1, y - 1));
        }
        if (y - 1 >= 0) {
            result.add(new Coordinate(x, y - 1));
        }
        if (x - 1 >= 0 && y - 1 >= 0) {
            result.add(new Coordinate(x - 1, y - 1));
        }
        if (x - 1 >= 0) {
            result.add(new Coordinate(x - 1, y));
        }
        if (x - 1 >= 0 && y + 1 < mapSize) {
            result.add(new Coordinate(x - 1, y + 1));
        }

        return result;
    }
}
