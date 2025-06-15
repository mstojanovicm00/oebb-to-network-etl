package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model;

import java.time.LocalTime;

public class StopTime implements Comparable<StopTime> {

    private final Trip trip;
    private final LocalTime arrivalTime, departureTime;
    private final int nextDay;
    private final Stop stop;
    private final int stopSequence;
    private final String stopHeadsign;
    private final int pickupType, dropOffType;
    private final double shapeDistanceTravelled;

    public StopTime(Trip trip, LocalTime arrivalTime, LocalTime departureTime, int nextDay, Stop stop, int stopSequence, String stopHeadsign, int pickupType, int dropOffType, double shapeDistanceTravelled) {
        this.trip = trip;
        this.arrivalTime = arrivalTime;
        this.departureTime = departureTime;
        this.nextDay = nextDay;
        this.stop = stop.highestAncestor();
        this.stopSequence = stopSequence;
        this.stopHeadsign = stopHeadsign;
        this.pickupType = pickupType;
        this.dropOffType = dropOffType;
        this.shapeDistanceTravelled = shapeDistanceTravelled;
        this.trip.getStopTimes().add(this);
    }

    @Override
    public int compareTo(StopTime stopTime) {
        return this.departureTime.compareTo(stopTime.departureTime);
    }

    @Override
    public String toString() {
        return "StopTime{" +
                "trip=" + trip +
                ", arrivalTime=" + arrivalTime +
                ", departureTime=" + departureTime +
                ", stop=" + stop +
                ", stopSequence=" + stopSequence +
                ", stopHeadsign='" + stopHeadsign + '\'' +
                ", pickupType=" + pickupType +
                ", dropOffType=" + dropOffType +
                ", shapeDistanceTravelled=" + shapeDistanceTravelled +
                '}';
    }

    public Trip getTrip() {
        return trip;
    }

    public LocalTime getArrivalTime() {
        return arrivalTime;
    }

    public LocalTime getDepartureTime() {
        return departureTime;
    }

    public Stop getStop() {
        return stop;
    }

    public int getStopSequence() {
        return stopSequence;
    }

    public String getStopHeadsign() {
        return stopHeadsign;
    }

    public int getPickupType() {
        return pickupType;
    }

    public int getDropOffType() {
        return dropOffType;
    }

    public double getShapeDistanceTravelled() {
        return shapeDistanceTravelled;
    }

    public int getNextDay() {
        return nextDay;
    }
}
