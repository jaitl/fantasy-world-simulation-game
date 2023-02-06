package pro.jaitl.game;

import java.util.ArrayList;
import java.util.List;

import pro.jaitl.game.action.Action;

public class Simulation {

    private final List<Action> initActions = new ArrayList<>();
    private final List<Action> turnActions = new ArrayList<>();
    private final WorldMap worldMap = new WorldMap();
    private int moveNumner = 1;

    public void addInitAction(Action action) {
        initActions.add(action);
    }

    public void addTurnAction(Action action) {
        turnActions.add(action);
    }

    public void startSimulation() {
        for(Action action : initActions) {
            action.doAction(worldMap);
        }

        while(true) {
            System.out.println("move numnber: " + moveNumner);
            nextTurn();
            moveNumner += 1;
        }
    }

    private void nextTurn() {
        for(Action action : turnActions) {
            action.doAction(worldMap);
        }    
    }
}
