package rs.raf.mstojanovic5623m.agpp.network.oebb.extract.readers;

import org.apache.commons.csv.CSVRecord;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Creator;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Finder;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Reader;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Route;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Service;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Trip;

import java.util.ArrayList;
import java.util.List;

public class TripReader implements Reader<Trip> {

    private final Creator<Service> serviceCreator;
    private final Finder<Route> routeFinder;

    public TripReader(Creator<Service> serviceCreator, Finder<Route> routeFinder) {
        this.serviceCreator = serviceCreator;
        this.routeFinder = routeFinder;
    }

    @Override
    public List<Trip> read(String path) {
        List<Trip> trips = new ArrayList<>();
        List<CSVRecord> csvRecords = this.csvParser(path);
        if (csvRecords != null) {
            for (CSVRecord csvRecord : csvRecords) {
                String[] a = this.splitRecord(csvRecord, 8);
                trips.add(new Trip(
                        this.routeFinder.find(a[0]).orElse(Route.INVALID),
                        this.serviceCreator.create(a[1]),
                        a[2],
                        a[3],
                        a[4],
                        a[5],
                        Integer.parseInt(a[6]),
                        a[7].isBlank() ? -1 : Integer.parseInt(a[7])
                ));
            }
        }
        return trips;
    }

    @Override
    public String file(String dir) {
        return dir + "/trips.txt";
    }
}
