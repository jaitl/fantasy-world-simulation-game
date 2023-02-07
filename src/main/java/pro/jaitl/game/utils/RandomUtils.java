package pro.jaitl.game.utils;

import pro.jaitl.game.map.Coordinate;

public class RandomUtils {
    /*
     * [min, max)
     */
    public static int randomNumber(int min, int max) {
        return (int) ((Math.random() * (max - min)) + min);
    }

    public static Coordinate randomCoordinate(int max) {
        return new Coordinate(randomNumber(0, max), randomNumber(0, max));
    }
}
