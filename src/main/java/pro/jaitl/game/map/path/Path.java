package pro.jaitl.game.map.path;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import pro.jaitl.game.map.Coordinate;

/*
 * Рекурсивная имьютабельная структура для хранения пути (напоминает LinkedList)
 */
public class Path {
    private final Coordinate coordinate;
    private final Path tail;
    
    public Path(Coordinate coordinate, Path tail) {
        this.coordinate = coordinate;
        this.tail = tail;
    }

    public static Path empty() {
        return new Path(null, null);
    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public Path getTail() {
        return tail;
    }

    public List<Coordinate> toList() {
        if (coordinate == null) {
            return Collections.emptyList();
        }
        List<Coordinate> result = new ArrayList<>();

        Path curPath = this;

        while(curPath != null) {
            result.add(curPath.getCoordinate());
            curPath = curPath.tail;
        }

        Collections.reverse(result);
        return result;
    }
}
