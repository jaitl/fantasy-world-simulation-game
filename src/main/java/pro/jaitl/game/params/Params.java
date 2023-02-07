package pro.jaitl.game.params;

public class Params {
    private int mapSize;
    private InitParams initParams;
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

    public InitParams getInitParams() {
        return initParams;
    }

    public void setInitParams(InitParams initParams) {
        this.initParams = initParams;
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
