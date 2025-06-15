package rs.raf.mstojanovic5623m.agpp.network.oebb.extract.readers;

import org.apache.commons.csv.CSVRecord;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Creator;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Finder;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Reader;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Stop;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Zone;

import java.util.ArrayList;
import java.util.List;

public class StopReader implements Reader<Stop> {

    private final Creator<Zone> zoneCreator;
    private final Finder<Stop> stopFinder;

    public StopReader(Creator<Zone> zoneCreator, Finder<Stop> stopFinder) {
        this.zoneCreator = zoneCreator;
        this.stopFinder = stopFinder;
    }

    @Override
    public List<Stop> read(String path) {
        List<Stop> stops = new ArrayList<>();
        List<CSVRecord> csvRecords = this.csvParser(path);
        if (csvRecords != null) {
            for (CSVRecord csvRecord : csvRecords) {
                String[] a = this.splitRecord(csvRecord, 9);
                stops.add(new Stop(
                        a[0],
                        a[1],
                        Double.parseDouble(a[2]),
                        Double.parseDouble(a[3]),
                        this.zoneCreator.create(a[4]),
                        a[5].isBlank() ? -1 : Integer.parseInt(a[5]),
                        this.stopFinder.find(a[6]).orElse(null),
                        a[7],
                        a[8]
                ));
            }
        }
        return stops;
    }

    @Override
    public String file(String dir) {
        return dir + "/stops.txt";
    }
}
