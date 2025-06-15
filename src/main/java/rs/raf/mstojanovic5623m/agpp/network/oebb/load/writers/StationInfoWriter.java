package rs.raf.mstojanovic5623m.agpp.network.oebb.load.writers;

import rs.raf.mstojanovic5623m.agpp.network.oebb.load.Writer;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;

public class StationInfoWriter implements Writer<StationInfo> {

    /**
     * private final String dataset = "oebb-2025";
     *     private final String id;
     *     private final String code;
     *     private final String name;
     *     private final String description;
     *     private final double latitude;
     *     private final double longitude;
     *     private final String url;
     */

    @Override
    public String[] write(StationInfo item) {

        return new String[] {
                item.getDataset(),
                item.getId(),
                item.getCode(),
                item.getName(),
                item.getDescription(),
                "" + item.getLatitude(),
                "" + item.getLongitude(),
                item.getUrl()
        };
    }

    @Override
    public String file(String dir) {
        return dir + "/stations.csv";
    }

    @Override
    public String[] headers() {
        return new String[] {
                "dataset",
                "station_id",
                "station_code",
                "station_name",
                "station_description",
                "station_latitude",
                "station_longitude",
                "station_url"
        };
    }
}
