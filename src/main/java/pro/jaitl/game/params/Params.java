package pro.jaitl.game.params;

public class Params {
    private int mapSize;
    private WorldSizeParams worldSizeParams;
    
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
}
