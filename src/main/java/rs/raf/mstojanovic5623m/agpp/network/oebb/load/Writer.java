package rs.raf.mstojanovic5623m.agpp.network.oebb.load;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.Writeable;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public interface Writer<T extends Writeable> {
    String[] write(T item);
    String file(String dir);
    String[] headers();

    default void writeAll(String dir, List<T> items) {
        CSVFormat format = CSVFormat.DEFAULT.builder().setHeader(this.headers()).get();
        FileWriter writer = null;
        CSVPrinter printer = null;
        try {
            writer = new FileWriter(this.file(dir));
            printer = new CSVPrinter(writer, format);
            for (T item : items) {
                if (item != null && item.isWriteable())
                    printer.printRecord((Object[]) this.write(item));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        } finally {
            if (printer != null) {
                try {
                    printer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
