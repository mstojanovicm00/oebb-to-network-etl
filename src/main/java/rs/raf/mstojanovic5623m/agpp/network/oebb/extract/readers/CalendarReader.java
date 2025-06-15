package rs.raf.mstojanovic5623m.agpp.network.oebb.extract.readers;

import org.apache.commons.csv.CSVRecord;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Creator;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Reader;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Calendar;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarReader implements Reader<Calendar> {

    private final Creator<Service> serviceCreator;

    public CalendarReader(Creator<Service> serviceCreator) {
        this.serviceCreator = serviceCreator;
    }

    @Override
    public List<Calendar> read(String path) {
        List<Calendar> calendars = new ArrayList<>();
        List<CSVRecord> csvRecords = this.csvParser(path);
        if (csvRecords != null) {
            for (CSVRecord csvRecord : csvRecords) {
                String[] a = this.splitRecord(csvRecord, 10);
                Service service = this.serviceCreator.create(a[0]);
                calendars.add(new Calendar(
                        service,
                        this.booleanOf(a[1]),
                        this.booleanOf(a[2]),
                        this.booleanOf(a[3]),
                        this.booleanOf(a[4]),
                        this.booleanOf(a[5]),
                        this.booleanOf(a[6]),
                        this.booleanOf(a[7]),
                        this.localDateOf(a[8]),
                        this.localDateOf(a[9])
                ));
            }
        }
        return calendars;
    }

    @Override
    public String file(String dir) {
        return dir + "/calendar.txt";
    }
}
