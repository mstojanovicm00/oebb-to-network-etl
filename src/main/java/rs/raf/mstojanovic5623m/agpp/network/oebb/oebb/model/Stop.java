package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model;

public class Stop {

    public static final Stop INVALID
            = new Stop("invalid", "", 0, 0, null,
            0, null, "", "");

    private final String stopId;
    private final String stopName;
    private final double stopLat, stopLon;
    private final Zone zone;
    private final int locationType;
    private final Stop parentStation;
    private final String levelId;
    private final String platformId;

    public Stop(String stopId, String stopName, double stopLat, double stopLon, Zone zone, int locationType, Stop parentStation, String levelId, String platformId) {
        this.stopId = stopId;
        this.stopName = stopName;
        this.stopLat = stopLat;
        this.stopLon = stopLon;
        this.zone = zone;
        this.locationType = locationType;
        this.parentStation = parentStation;
        this.levelId = levelId;
        this.platformId = platformId;
    }

    public Stop highestAncestor() {
        if (this.parentStation == null)
            return this;
        return this.parentStation.highestAncestor();
    }

    @Override
    public String toString() {
        return "Stop{" +
                "stopId='" + stopId + '\'' +
                ", stopName='" + stopName + '\'' +
                ", stopLat=" + stopLat +
                ", stopLon=" + stopLon +
                ", zone=" + zone +
                ", locationType=" + locationType +
                ", parentStation=" + parentStation +
                ", levelId=" + levelId +
                ", platformId=" + platformId +
                '}';
    }

    public String getStopId() {
        return stopId;
    }

    public String getStopName() {
        return stopName;
    }

    public double getStopLat() {
        return stopLat;
    }

    public double getStopLon() {
        return stopLon;
    }

    public Zone getZone() {
        return zone;
    }

    public int getLocationType() {
        return locationType;
    }

    public Stop getParentStation() {
        return parentStation;
    }

    public String getLevelId() {
        return levelId;
    }

    public String getPlatformId() {
        return platformId;
    }
}
