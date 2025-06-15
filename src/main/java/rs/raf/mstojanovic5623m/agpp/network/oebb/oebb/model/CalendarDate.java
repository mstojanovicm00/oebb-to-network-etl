package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model;

import java.time.LocalDate;

public class CalendarDate {

    private final Service service;
    private final LocalDate date;
    private final int exceptionType;

    public CalendarDate(Service service, LocalDate date, int exceptionType) {
        this.service = service;
        this.date = date;
        this.exceptionType = exceptionType;
    }

    @Override
    public String toString() {
        return "CalendarDate{" +
                "service=" + service +
                ", date=" + date +
                ", exceptionType=" + exceptionType +
                '}';
    }

    public Service getService() {
        return service;
    }

    public LocalDate getDate() {
        return date;
    }

    public int getExceptionType() {
        return exceptionType;
    }
}
