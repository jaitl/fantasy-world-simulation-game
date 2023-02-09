package pro.jaitl.game.map.path;

import pro.jaitl.game.map.Coordinate;

/*
 * Алгоритм принятия решения о координате при ее посещении.
 * Решает что делать с конкретной координатой.
 */
public interface CoordinateDesigionStrategy {
    Desigion analize(Coordinate coordinate);
}
