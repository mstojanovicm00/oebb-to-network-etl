package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb;

import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.*;

import java.util.ArrayList;
import java.util.List;

public class OEBBRepository {

    private final List<Agency> agencies = new ArrayList<>();
    private final List<Calendar> calendars = new ArrayList<>();
    private final List<CalendarDate> calendarDates = new ArrayList<>();
    private final List<Route> routes = new ArrayList<>();
    private final List<Service> services = new ArrayList<>();
    private final List<Stop> stops = new ArrayList<>();
    private final List<StopTime> stopTimes = new ArrayList<>();
    private final List<Trip> trips = new ArrayList<>();
    private final List<Zone> zones = new ArrayList<>();

    public List<Agency> getAgencies() {
        return agencies;
    }

    public List<Calendar> getCalendars() {
        return calendars;
    }

    public List<CalendarDate> getCalendarDates() {
        return calendarDates;
    }

    public List<Route> getRoutes() {
        return routes;
    }

    public List<Service> getServices() {
        return services;
    }

    public List<Stop> getStops() {
        return stops;
    }

    public List<StopTime> getStopTimes() {
        return stopTimes;
    }

    public List<Trip> getTrips() {
        return trips;
    }

    public List<Zone> getZones() {
        return zones;
    }
}
