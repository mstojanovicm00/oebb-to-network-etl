package rs.raf.mstojanovic5623m.agpp.network.oebb.transform.coverters;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Stop;
import rs.raf.mstojanovic5623m.agpp.network.oebb.transform.Converter;

import java.util.function.Predicate;

public class StationConverter implements Converter<Stop, StationInfo> {
    @Override
    public StationInfo convert(Stop input) {
        return new StationInfo.StationInfoBuilder()
                .setId(input.getStopId())
                .setName(input.getStopName())
                .setLatitude(input.getStopLat())
                .setLongitude(input.getStopLon())
                .toStationInfo();
    }

    @Override
    public Predicate<Stop> shouldConvert() {
        return stop -> stop.getLocationType() == 1
                || stop.getParentStation() == null
                || stop.getParentStation() == Stop.INVALID
                ;
    }
}
