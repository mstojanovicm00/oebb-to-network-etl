package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model;

import java.util.ArrayList;
import java.util.List;

public class Trip {

    public static final Trip INVALID
            = new Trip(
                    null, null,
            "", "", "", "",
            0, 0
    );

    private final Route route;
    private final Service service;
    private final String tripId;
    private final String shapeId;
    private final String tripHeadsign;
    private final String tripShortName;
    private final int direction;
    private final int block;

    private final List<StopTime> stopTimes = new ArrayList<>();

    public Trip(Route route, Service service, String tripId, String shapeId, String tripHeadsign, String tripShortName, int direction, int block) {
        this.route = route;
        this.service = service;
        this.tripId = tripId;
        this.shapeId = shapeId;
        this.tripHeadsign = tripHeadsign;
        this.tripShortName = tripShortName;
        this.direction = direction;
        this.block = block;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "route=" + route +
                ", service=" + service +
                ", tripId='" + tripId + '\'' +
                ", shapeId='" + shapeId + '\'' +
                ", tripHeadsign='" + tripHeadsign + '\'' +
                ", tripShortName='" + tripShortName + '\'' +
                ", direction=" + direction +
                ", block=" + block +
                '}';
    }

    public Route getRoute() {
        return route;
    }

    public Service getService() {
        return service;
    }

    public String getTripId() {
        return tripId;
    }

    public String getShapeId() {
        return shapeId;
    }

    public String getTripHeadsign() {
        return tripHeadsign;
    }

    public String getTripShortName() {
        return tripShortName;
    }

    public int getDirection() {
        return direction;
    }

    public int getBlock() {
        return block;
    }

    public List<StopTime> getStopTimes() {
        return stopTimes;
    }
}
