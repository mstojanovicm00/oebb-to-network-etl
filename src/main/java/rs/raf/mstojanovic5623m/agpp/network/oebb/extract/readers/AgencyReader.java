package rs.raf.mstojanovic5623m.agpp.network.oebb.extract.readers;

import org.apache.commons.csv.CSVRecord;
import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Reader;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model.Agency;

import java.util.ArrayList;
import java.util.List;

public class AgencyReader implements Reader<Agency> {
    @Override
    public List<Agency> read(String path) {
        List<Agency> agencies = new ArrayList<>();
        List<CSVRecord> csvRecords = this.csvParser(path);
        if (csvRecords != null) {
            for (CSVRecord csvRecord : csvRecords) {
                String[] a = this.splitRecord(csvRecord, 6);
                agencies.add(new Agency(a[0], a[1], a[2], a[3], a[4], a[5]));
            }
        }
        return agencies;
    }

    @Override
    public String file(String dir) {
        return dir + "/agency.txt";
    }
}
