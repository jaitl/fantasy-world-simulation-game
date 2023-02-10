package pro.jaitl.game;

import java.util.List;

import pro.jaitl.game.action.Action;
import pro.jaitl.game.action.GenerateWorldMapAction;
import pro.jaitl.game.action.InitWorldMapAction;
import pro.jaitl.game.action.MakeMoveAction;
import pro.jaitl.game.params.HerbivoreParams;
import pro.jaitl.game.params.WorldSizeParams;
import pro.jaitl.game.params.Params;
import pro.jaitl.game.params.PredatorParams;

public class App {

    public static void main(String[] args) {
        List<Action> initActions = List.of(
            new InitWorldMapAction()
        );
        List<Action> turnActions = List.of(
            new MakeMoveAction(),
            new GenerateWorldMapAction()
        );

        WorldSizeParams worldSizeParams = new WorldSizeParams();
        worldSizeParams.setAlivePersent(0.3f);
        worldSizeParams.setGrossCount(40);
        worldSizeParams.setTreeCount(10);
        worldSizeParams.setRockCount(10);
        worldSizeParams.setHerbivoreCount(10);
        worldSizeParams.setPredatorCount(2);

        PredatorParams predatorParams = new PredatorParams();
        predatorParams.setStrength(2);
        predatorParams.setMaxHealth(10);
        predatorParams.setMoveCount(2);

        HerbivoreParams herbivoreParams = new HerbivoreParams();
        herbivoreParams.setMaxHealth(10);
        herbivoreParams.setMoveCount(3);

        Params params = new Params();
        params.setMapSize(20);
        params.setWorldSizeParams(worldSizeParams);
        params.setPredatorParams(predatorParams);
        params.setHerbivoreParams(herbivoreParams);

        Simulation simulation = new Simulation(initActions, turnActions, params);

        System.out.println("=== start simulation ===");
        simulation.startSimulation();
        System.out.println("=== end simulation ===");
    }
}
