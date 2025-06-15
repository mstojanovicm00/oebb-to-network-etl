package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model;

import java.util.Objects;

public class Zone {

    private final String zoneId;

    public Zone(String zoneId) {
        this.zoneId = zoneId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Zone zone = (Zone) o;
        return Objects.equals(zoneId, zone.zoneId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(zoneId);
    }

    @Override
    public String toString() {
        return "Zone{" +
                "zoneId='" + zoneId + '\'' +
                '}';
    }

    public String getZoneId() {
        return zoneId;
    }
}
