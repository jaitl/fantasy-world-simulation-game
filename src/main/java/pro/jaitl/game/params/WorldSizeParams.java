package pro.jaitl.game.params;

public class WorldSizeParams {
    private int treeCount;
    private int grossCount;
    private int rockCount;
    private int herbivoreCount;
    private int predatorCount;
    
    public WorldSizeParams() {
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

    public int getRockCount() {
        return rockCount;
    }

    public void setRockCount(int rockCount) {
        this.rockCount = rockCount;
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
