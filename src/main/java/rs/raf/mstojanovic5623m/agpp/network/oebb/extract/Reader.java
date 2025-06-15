package rs.raf.mstojanovic5623m.agpp.network.oebb.extract;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface Reader<T> {
    List<T> read(String path);
    String file(String dir);

    default List<CSVRecord> csvParser(String path) {
        BufferedReader bufferedReader;
        CSVParser csvParser;
        try {
            bufferedReader = Files.newBufferedReader(Paths.get(this.file(path)));
            csvParser = new CSVParser(bufferedReader, CSVFormat.DEFAULT);
            List<CSVRecord> records = csvParser.getRecords();
            records.remove(0);
            return records;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    default String[] splitRecord(CSVRecord csvRecord, int numberOfFields) {
        String[] fields = new String[numberOfFields];
        for (int i = 0; i < numberOfFields; i++)
            fields[i] = csvRecord.get(i);
        return fields;
    }

    default boolean booleanOf(String number) {
        return Integer.parseInt(number) == 1;
    }

    default LocalDate localDateOf(String date) {
        return LocalDate.of(
                Integer.parseInt(date.substring(0, 4)),
                Integer.parseInt(date.substring(4, 6)),
                Integer.parseInt(date.substring(6))
        );
    }

    default int[] localTimeOf(String time) {
        int hour = Integer.parseInt(time.substring(0, 2));
        int minute = Integer.parseInt(time.substring(3, 5));
        int second = Integer.parseInt(time.substring(6));
        int day = hour / 24;
        hour %= 24;
        return new int[]{day, hour, minute, second};
    }
}
