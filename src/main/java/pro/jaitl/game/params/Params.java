package pro.jaitl.game.params;

public class Params {
    private int mapSize;
    private WorldSizeParams worldSizeParams;
    private HerbivoreParams herbivoreParams;
    private PredatorParams predatorParams;
    
    public Params() {
    }

    public int getMapSize() {
        return mapSize;
    }

    public void setMapSize(int mapSize) {
        this.mapSize = mapSize;
    }

    public WorldSizeParams getWorldSizeParams() {
        return worldSizeParams;
    }

    public void setWorldSizeParams(WorldSizeParams worldSizeParams) {
        this.worldSizeParams = worldSizeParams;
    }

    public HerbivoreParams getHerbivoreParams() {
        return herbivoreParams;
    }

    public void setHerbivoreParams(HerbivoreParams herbivoreParams) {
        this.herbivoreParams = herbivoreParams;
    }

    public PredatorParams getPredatorParams() {
        return predatorParams;
    }

    public void setPredatorParams(PredatorParams predatorParams) {
        this.predatorParams = predatorParams;
    }
}
