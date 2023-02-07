package pro.jaitl.game.params;

public class InitParams {
    private int treeCount;
    private int grossCount;
    private int herbivoreCount;
    private int predatorCount;
    
    public InitParams() {
    }

    public int getTreeCount() {
        return treeCount;
    }

    public void setTreeCount(int treeCount) {
        this.treeCount = treeCount;
    }

    public int getGrossCount() {
        return grossCount;
    }

    public void setGrossCount(int grossCount) {
        this.grossCount = grossCount;
    }

    public int getHerbivoreCount() {
        return herbivoreCount;
    }

    public void setHerbivoreCount(int herbivoreCount) {
        this.herbivoreCount = herbivoreCount;
    }

    public int getPredatorCount() {
        return predatorCount;
    }

    public void setPredatorCount(int predatorCount) {
        this.predatorCount = predatorCount;
    }
}