package pro.jaitl.game;

import java.util.List;

import pro.jaitl.game.action.Action;

public class App {

    public static void main(String[] args) {
        List<Action> initActions = List.of();
        List<Action> turnActions = List.of();

        Params params = new Params();

        Simulation simulation = new Simulation(initActions, turnActions, params);
        System.out.println("=== start simulation ===");
        simulation.startSimulation();
        System.out.println("=== end simulation ===");
    }
}
