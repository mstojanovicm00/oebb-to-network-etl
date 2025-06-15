package rs.raf.mstojanovic5623m.agpp.network.oebb.extract.readers;

import org.apache.commons.csv.CSVRecord;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Creator;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Reader;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.CalendarDate;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class CalendarDateReader implements Reader<CalendarDate> {

    private final Creator<Service> serviceCreator;

    public CalendarDateReader(Creator<Service> serviceCreator) {
        this.serviceCreator = serviceCreator;
    }

    @Override
    public List<CalendarDate> read(String path) {
        List<CalendarDate> calendarDates = new ArrayList<>();
        List<CSVRecord> csvRecords = this.csvParser(path);
        if (csvRecords != null) {
            for (CSVRecord csvRecord : csvRecords) {
                String[] a = this.splitRecord(csvRecord, 3);
                Service service = this.serviceCreator.create(a[0]);
                LocalDate localDate = this.localDateOf(a[1]);
                int exception = Integer.parseInt(a[2]);
                calendarDates.add(new CalendarDate(service, localDate, exception));
            }
        }
        return calendarDates;
    }

    @Override
    public String file(String dir) {
        return dir + "/calendar_dates.txt";
    }
}
