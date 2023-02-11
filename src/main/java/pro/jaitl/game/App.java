package pro.jaitl.game;

import java.util.List;

import pro.jaitl.game.action.Action;
import pro.jaitl.game.action.GenerateWorldMapAction;
import pro.jaitl.game.action.InitWorldMapAction;
import pro.jaitl.game.action.MakeMoveAction;
import pro.jaitl.game.params.Params;
import pro.jaitl.game.params.WorldSizeParams;

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
        worldSizeParams.setGrossCount(40);
        worldSizeParams.setTreeCount(20);
        worldSizeParams.setRockCount(20);
        worldSizeParams.setHerbivoreCount(10);
        worldSizeParams.setPredatorCount(2);

        Params params = new Params();
        params.setMapSize(20);
        params.setWorldSizeParams(worldSizeParams);

        Simulation simulation = new Simulation(initActions, turnActions, params);

        System.out.println("=== start simulation ===");
        simulation.startSimulation();
        System.out.println("=== end simulation ===");
    }
}
