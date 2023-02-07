package pro.jaitl.game;

import java.util.List;

import pro.jaitl.game.action.Action;
import pro.jaitl.game.action.InitMapAction;
import pro.jaitl.game.params.HerbivoreParams;
import pro.jaitl.game.params.InitParams;
import pro.jaitl.game.params.Params;
import pro.jaitl.game.params.PredatorParams;

public class App {

    public static void main(String[] args) {
        List<Action> initActions = List.of(
            new InitMapAction()
        );
        List<Action> turnActions = List.of();

        InitParams initParams = new InitParams();
        initParams.setGrossCount(10);
        initParams.setTreeCount(10);
        initParams.setHerbivoreCount(10);
        initParams.setPredatorCount(2);

        PredatorParams predatorParams = new PredatorParams();
        predatorParams.setMaxHealth(2);
        predatorParams.setMaxHealth(10);
        predatorParams.setMoveCount(2);

        HerbivoreParams herbivoreParams = new HerbivoreParams();
        herbivoreParams.setMaxHealth(20);
        herbivoreParams.setMoveCount(3);

        Params params = new Params();
        params.setMapSize(10);
        params.setInitParams(initParams);
        params.setPredatorParams(predatorParams);
        params.setHerbivoreParams(herbivoreParams);

        Simulation simulation = new Simulation(initActions, turnActions, params);

        System.out.println("=== start simulation ===");
        simulation.startSimulation();
        System.out.println("=== end simulation ===");
    }
}
