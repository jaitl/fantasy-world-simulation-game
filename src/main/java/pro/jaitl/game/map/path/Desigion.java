package pro.jaitl.game.map.path;

/*
 * Решение о рассмотрении сущности поля
 */
public enum Desigion {
    /*
     * Нейтральная сущность, можно просто пройти через нее
     */
    neutral,
    /*
     * Препядствие через которое нельзя пройти
     */
    obstacle,
    /*
     * В ячейке находится цель поиска, поиск можно остановить
     */
    target
}