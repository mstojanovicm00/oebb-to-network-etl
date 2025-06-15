package rs.raf.mstojanovic5623m.agpp.network.oebb.transform.coverters;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.TranslationInfo;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Stop;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.StopTime;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Trip;
import rs.raf.mstojanovic5623m.agpp.network.oebb.transform.Converter;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;

public class TranslationConverter implements Converter<Trip, List<TranslationInfo>> {

    private final List<StationInfo> stations;

    public TranslationConverter(List<StationInfo> stations) {
        this.stations = stations;
    }

    @Override
    public List<TranslationInfo> convert(Trip input) {
        Collections.sort(input.getStopTimes());
        List<TranslationInfo> translationInfos = new ArrayList<>();
        StationInfo prev = this.getStationInfo(input.getStopTimes().get(0));
        String agency = input.getRoute().getAgency().getAgencyName();
        String service = input.getService().getServiceId();
        for (int i = 1; i < input.getStopTimes().size(); i++) {
            StationInfo from = prev;
            StationInfo to = this.getStationInfo(input.getStopTimes().get(i));
            LocalTime departure = input.getStopTimes().get(i - 1).getDepartureTime();
            LocalTime arrival = input.getStopTimes().get(i).getArrivalTime();
            int nextDay = input.getStopTimes().get(i).getNextDay();
            translationInfos.add(new TranslationInfo.TranslationInfoBuilder()
                    .setFrom(from)
                    .setTo(to)
                    .setAgency(agency)
                    .setService(service)
                    .setDepartureTime(departure)
                    .setArrivalTime(arrival)
                    .setNextDay(nextDay)
                    .toTranslationInfo());
            prev = to;
        }
        return translationInfos;
    }

    private StationInfo getStationInfo(StopTime stopTime) {
        Stop stop = stopTime.getStop();
        while (stop.getParentStation() != null)
            stop = stop.getParentStation();
        for (StationInfo stationInfo : stations) {
            if (stationInfo.getId().equals(stop.getStopId()))
                return stationInfo;
        }
        return null;
    }

    @Override
    public Predicate<Trip> shouldConvert() {
        return t -> true;
    }

    public List<StationInfo> getStations() {
        return stations;
    }
}
