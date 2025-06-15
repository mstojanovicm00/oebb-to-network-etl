package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model;

public class Route {

    public static final Route INVALID
            = new Route(
                    "invalid", null,
            "", "", 0);

    private final String routeId;
    private final Agency agency;
    private final String routeShortName, routeLongName;
    private final int routeType;

    public Route(String routeId, Agency agency, String routeShortName, String routeLongName, int routeType) {
        this.routeId = routeId;
        this.agency = agency;
        this.routeShortName = routeShortName;
        this.routeLongName = routeLongName;
        this.routeType = routeType;
    }

    @Override
    public String toString() {
        return "Route{" +
                "routeId='" + routeId + '\'' +
                ", agency=" + agency +
                ", routeShortName='" + routeShortName + '\'' +
                ", routeLongName='" + routeLongName + '\'' +
                ", routeType=" + routeType +
                '}';
    }

    public String getRouteId() {
        return routeId;
    }

    public Agency getAgency() {
        return agency;
    }

    public String getRouteShortName() {
        return routeShortName;
    }

    public String getRouteLongName() {
        return routeLongName;
    }

    public int getRouteType() {
        return routeType;
    }
}
