package rs.raf.mstojanovic5623m.agpp.network.oebb.extract.readers;

import org.apache.commons.csv.CSVRecord;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Finder;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Reader;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Agency;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Route;

import java.util.ArrayList;
import java.util.List;

public class RouteReader implements Reader<Route> {

    private final Finder<Agency> agencyFinder;

    public RouteReader(Finder<Agency> agencyFinder) {
        this.agencyFinder = agencyFinder;
    }

    @Override
    public List<Route> read(String path) {
        List<Route> routes = new ArrayList<>();
        List<CSVRecord> csvRecords = this.csvParser(path);
        if (csvRecords != null) {
            for (CSVRecord csvRecord : csvRecords) {
                String[] a = this.splitRecord(csvRecord, 5);
                routes.add(new Route(
                        a[0],
                        this.agencyFinder.find(a[1]).orElse(Agency.INVALID),
                        a[2],
                        a[3],
                        Integer.parseInt(a[4])
                ));
            }
        }
        return routes;
    }

    @Override
    public String file(String dir) {
        return dir + "/routes.txt";
    }
}
