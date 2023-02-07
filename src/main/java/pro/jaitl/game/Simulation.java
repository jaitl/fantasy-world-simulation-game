package pro.jaitl.game;

import java.util.List;

import pro.jaitl.game.action.Action;

public class Simulation {

    private final List<Action> initActions;
    private final List<Action> turnActions;
    private final Params params;

    private final WorldMap worldMap = new WorldMap();
    private int moveNumner = 1;

    public Simulation(List<Action> initActions, List<Action> turnActions, Params params) {
        this.initActions = initActions;
        this.turnActions = turnActions;
        this.params = params;
    }

    public void startSimulation() {
        for(Action action : initActions) {
            action.doAction(worldMap, params);
        }

        while(true) {
            System.out.println("move numnber: " + moveNumner);
            nextTurn();
            moveNumner += 1;
        }
    }

    private void nextTurn() {
        for(Action action : turnActions) {
            action.doAction(worldMap, params);
        }    
    }
}
