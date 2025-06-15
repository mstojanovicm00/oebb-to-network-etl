package rs.raf.mstojanovic5623m.agpp.network.oebb.extract.readers;

import org.apache.commons.csv.CSVRecord;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Finder;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Reader;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Stop;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.StopTime;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Trip;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class StopTimeReader implements Reader<StopTime> {

    private final Finder<Trip> tripFinder;
    private final Finder<Stop> stopFinder;

    public StopTimeReader(Finder<Trip> tripFinder, Finder<Stop> stopFinder) {
        this.tripFinder = tripFinder;
        this.stopFinder = stopFinder;
    }

    @Override
    public List<StopTime> read(String path) {
        List<StopTime> stopTimes = new ArrayList<>();
        List<CSVRecord> csvRecords = this.csvParser(path);
        if (csvRecords != null) {
            for (CSVRecord csvRecord : csvRecords) {
                String[] a = this.splitRecord(csvRecord, 9);
                int[] start = this.localTimeOf(a[1]);
                int[] end = this.localTimeOf(a[2]);
                stopTimes.add(new StopTime(
                        this.tripFinder.find(a[0]).orElse(Trip.INVALID),
                        LocalTime.of(start[1], start[2], start[3]),
                        LocalTime.of(end[1], end[2], end[3]),
                        end[0],
                        this.stopFinder.find(a[3]).orElse(Stop.INVALID),
                        Integer.parseInt(a[4]),
                        a[5],
                        Integer.parseInt(a[6]),
                        Integer.parseInt(a[7]),
                        Double.parseDouble(a[8])
                ));
            }
        }
        return stopTimes;
    }

    @Override
    public String file(String dir) {
        return dir + "/stop_times.txt";
    }
}
