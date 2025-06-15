package rs.raf.mstojanovic5623m.agpp.network.oebb.extract;

import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.readers.*;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.OEBBRepository;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.*;

public class Extracter {

    private final OEBBRepository oebbRepository = new OEBBRepository();

    private final Creator<Service> serviceCreator = new Creator<>(Service::new);
    private final Creator<Zone> zoneCreator = new Creator<>(Zone::new);

    private final Finder<Agency> agencyFinder = new Finder<>(
            id -> {
                for (Agency agency : this.oebbRepository.getAgencies()) {
                    if (agency.getAgencyId().equals(id))
                        return agency;
                }
                return null;
            }
    );
    private final Finder<Route> routeFinder = new Finder<>(
            id -> {
                for (Route route : this.oebbRepository.getRoutes()) {
                    if (route.getRouteId().equals(id))
                        return route;
                }
                return null;
            }
    );
    private final Finder<Stop> stopFinder = new Finder<>(
            id -> {
                for (Stop stop : this.oebbRepository.getStops()) {
                    if (stop.getStopId().equals(id))
                        return stop;
                }
                return null;
            }
    );
    private final Finder<Trip> tripFinder = new Finder<>(
            id -> {
                for (Trip trip : this.oebbRepository.getTrips()) {
                    if (trip.getTripId().equals(id))
                        return trip;
                }
                return null;
            }
    );

    private final Reader<Agency> agencyReader
            = new AgencyReader();
    private final Reader<Calendar> calendarReader
            = new CalendarReader(this.serviceCreator);
    private final Reader<CalendarDate> calendarDateReader
            = new CalendarDateReader(this.serviceCreator);
    private final Reader<Route> routeReader
            = new RouteReader(this.agencyFinder);
    private final Reader<Stop> stopReader
            = new StopReader(this.zoneCreator, this.stopFinder);
    private final Reader<StopTime> stopTimeReader
            = new StopTimeReader(this.tripFinder, this.stopFinder);
    private final Reader<Trip> tripReader
            = new TripReader(this.serviceCreator, this.routeFinder);

    public OEBBRepository extract(String path) {
        this.oebbRepository.getAgencies().addAll(this.agencyReader.read(path));
        this.oebbRepository.getCalendars().addAll(this.calendarReader.read(path));
        this.oebbRepository.getCalendarDates().addAll(this.calendarDateReader.read(path));
        this.oebbRepository.getRoutes().addAll(this.routeReader.read(path));
        this.oebbRepository.getStops().addAll(this.stopReader.read(path));
        this.oebbRepository.getTrips().addAll(this.tripReader.read(path));
        this.oebbRepository.getStopTimes().addAll(this.stopTimeReader.read(path));

        this.oebbRepository.getServices().addAll(this.serviceCreator.getItems());
        this.oebbRepository.getZones().addAll(this.zoneCreator.getItems());

        return this.oebbRepository;
    }
}
