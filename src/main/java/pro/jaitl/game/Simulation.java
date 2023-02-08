package pro.jaitl.game;

import java.util.List;

import pro.jaitl.game.action.Action;
import pro.jaitl.game.map.WorldMap;
import pro.jaitl.game.params.Params;

public class Simulation {

    private final List<Action> initActions;
    private final List<Action> turnActions;
    private final Params params;
    private final WorldMap worldMap;

    public Simulation(List<Action> initActions, List<Action> turnActions, Params params) {
        this.initActions = initActions;
        this.turnActions = turnActions;
        this.params = params;
        this.worldMap = new WorldMap(params.getMapSize());
    }

    public void startSimulation() {
        int moveNumner = 1;

        for(Action action : initActions) {
            action.doAction(worldMap, params);
        }
        System.out.println("start map:");
        System.out.print(worldMap);

        /*
        while(true) {
            System.out.println("move number: " + moveNumner);
            nextTurn();
            moveNumner += 1;
        }
        */
    }

    private void nextTurn() {
        for(Action action : turnActions) {
            action.doAction(worldMap, params);
        }    
    }
}
