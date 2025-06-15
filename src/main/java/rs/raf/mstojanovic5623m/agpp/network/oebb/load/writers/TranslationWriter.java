package rs.raf.mstojanovic5623m.agpp.network.oebb.load.writers;

import rs.raf.mstojanovic5623m.agpp.network.oebb.load.Writer;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.TranslationInfo;

public class TranslationWriter implements Writer<TranslationInfo> {

    /**
     * private final int translationId;
     *     private final StationInfo from;
     *     private final StationInfo to;
     *     private final String agency;
     *     private final String service;
     *     private final LocalTime departureTime;
     *     private final LocalTime arrivalTime;
     *     private final int nextDay;
     */

    @Override
    public String[] write(TranslationInfo item) {
        item.setId();
        return new String[] {
                "" + item.getTranslationId(),
                item.getFrom().getName(),
                item.getTo().getName(),
                item.getAgency(),
                item.getService(),
                item.getDepartureTime().toString(),
                item.getArrivalTime().toString(),
                "" + item.getNextDay()
        };
    }

    @Override
    public String file(String dir) {
        return dir + "/translations.csv";
    }

    @Override
    public String[] headers() {
        return new String[] {
                "translation_id",
                "translation_from",
                "translation_to",
                "agency",
                "service",
                "departure_time",
                "arrival_time",
                "next_day"
        };
    }
}
