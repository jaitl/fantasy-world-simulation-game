package pro.jaitl.game.map.path;

import static org.junit.jupiter.api.Assertions.assertIterableEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.Test;

import pro.jaitl.game.map.Coordinate;

public class PathSearchBfsImplTest {

    @Test
    public void test_FindPath_Success_Size_4() {
        PathSearchBfsImpl search = new PathSearchBfsImpl(4);
        CoordinateDesigionStrategy strategy = c -> {
            if (c.getX() == 3 && c.getY() == 3) return Desigion.target;
            return Desigion.neutral;
        };

        Path foundPath = search.find(strategy, new Coordinate(0, 0));

        List<Coordinate> expected = List.of(
            new Coordinate(1, 1),
            new Coordinate(2, 2),
            new Coordinate(3, 3)
        );

        assertIterableEquals(expected, foundPath.toList());
    }

    @Test
    public void test_FindPath_Success_Size_5() {
        PathSearchBfsImpl search = new PathSearchBfsImpl(4);
        CoordinateDesigionStrategy strategy = c -> {
            if (c.getX() == 0 && c.getY() == 0) return Desigion.target;
            return Desigion.neutral;
        };

        Path foundPath = search.find(strategy, new Coordinate(4, 4));

        List<Coordinate> expected = List.of(
            new Coordinate(3, 3),
            new Coordinate(2, 2),
            new Coordinate(1, 1),
            new Coordinate(0, 0)
        );

        assertIterableEquals(expected, foundPath.toList());
    }

    @Test
    public void test_FindPath_Failed_Size_2() {
        PathSearchBfsImpl search = new PathSearchBfsImpl(2);
        CoordinateDesigionStrategy strategy = c -> {
            if (c.getX() == 3 && c.getY() == 3) return Desigion.target;
            return Desigion.neutral;
        };

        Path foundPath = search.find(strategy, new Coordinate(0, 0));

        assertTrue(foundPath.toList().isEmpty());;
    }
}
