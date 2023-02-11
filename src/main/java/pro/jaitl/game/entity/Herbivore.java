package pro.jaitl.game.entity;

import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.map.path.CoordinateDesigionStrategy;
import pro.jaitl.game.map.path.Desigion;

public class Herbivore extends Creature {

    public Herbivore() {
        super("🐮");
    }

    @Override
    protected CoordinateDesigionStrategy searchStrategy(WorldMap map) {
        return coordinate -> {
            Entity entity = map.getEntity(coordinate);

            if (entity == null) {
                return Desigion.neutral;
            }
            if (entity instanceof Grass) {
                return Desigion.target;
            }

            return Desigion.obstacle;
        };
    }

    @Override
    protected Reaction reactionOnEntity(Entity entity) {
        if (entity instanceof Grass) {
            return Reaction.eat;
        }
        return Reaction.move;
    }
}
