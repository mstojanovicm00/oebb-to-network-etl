package rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.Writeable;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.utilities.PrimaryKeyUtils;

import java.time.LocalTime;

public class TranslationInfo implements Writeable {

    private int translationId;
    private final StationInfo from;
    private final StationInfo to;
    private final String agency;
    private final String service;
    private final LocalTime departureTime;
    private final LocalTime arrivalTime;
    private final int nextDay;
    private Edgeable edge;

    public TranslationInfo(StationInfo from, StationInfo to, String agency, String service,
                           LocalTime departureTime, LocalTime arrivalTime, int nextDay,
                           double duration) {
        this.translationId = 0;
        this.from = from;
        this.to = to;
        this.agency = agency;
        this.service = service;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.nextDay = nextDay;
        this.edge = new EdgeBuilder(from, to, duration);
        this.from.addOutTranslation(this);
        this.to.addInTranslation(this);
    }

    @Override
    public boolean isWriteable() {
        return true;
    }

    @Override
    public String toString() {
        return "TranslationInfo{" +
                "translationId=" + translationId +
                ", from=" + from +
                ", to=" + to +
                ", agency='" + agency + '\'' +
                ", service='" + service + '\'' +
                ", departureTime=" + departureTime +
                ", arrivalTime=" + arrivalTime +
                ", nextDay=" + nextDay +
                ", edge=" + edge +
                '}';
    }

    public void setId() {
        this.translationId = PrimaryKeyUtils.generateNextKey("translation");
    }

    public int getTranslationId() {
        return translationId;
    }

    public StationInfo getFrom() {
        return from;
    }

    public StationInfo getTo() {
        return to;
    }

    public String getAgency() {
        return agency;
    }

    public String getService() {
        return service;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public int getNextDay() {
        return nextDay;
    }

    public Edgeable getEdge() {
        return edge;
    }

    public void setEdge(Edgeable edge) {
        this.edge = edge;
    }

    public static class TranslationInfoBuilder {
        private StationInfo from = null;
        private StationInfo to = null;
        private String agency = "";
        private String service = "";
        private LocalTime departureTime = null;
        private LocalTime arrivalTime = null;
        private int nextDay = 0;

        public TranslationInfo toTranslationInfo() {
            return new TranslationInfo(from, to, agency, service,
                    departureTime, arrivalTime, nextDay, this.duration());
        }

        private double duration() {
            int hour = (this.arrivalTime.getHour() - this.departureTime.getHour()) % 24;
            int minute = (this.arrivalTime.getMinute() - this.departureTime.getMinute()) % 60;
            int second = (this.arrivalTime.getSecond() - this.departureTime.getSecond()) % 60;
            return this.nextDay * 24 * 60 + hour * 60 + minute + second / 60.0;
        }

        public TranslationInfoBuilder setFrom(StationInfo from) {
            this.from = from;
            return this;
        }

        public TranslationInfoBuilder setTo(StationInfo to) {
            this.to = to;
            return this;
        }

        public TranslationInfoBuilder setAgency(String agency) {
            this.agency = agency;
            return this;
        }

        public TranslationInfoBuilder setService(String service) {
            this.service = service;
            return this;
        }

        public TranslationInfoBuilder setDepartureTime(LocalTime departureTime) {
            this.departureTime = departureTime;
            return this;
        }

        public TranslationInfoBuilder setArrivalTime(LocalTime arrivalTime) {
            this.arrivalTime = arrivalTime;
            return this;
        }

        public TranslationInfoBuilder setNextDay(int nextDay) {
            this.nextDay = nextDay;
            return this;
        }
    }
}
