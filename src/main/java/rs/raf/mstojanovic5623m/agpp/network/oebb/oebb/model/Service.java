package rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.model;

import java.util.Objects;

public class Service {

    private final String serviceId;

    public Service(String serviceId) {
        this.serviceId = serviceId;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Service service = (Service) o;
        return Objects.equals(serviceId, service.serviceId);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(serviceId);
    }

    @Override
    public String toString() {
        return "Service{" +
                "serviceId='" + serviceId + '\'' +
                '}';
    }

    public String getServiceId() {
        return serviceId;
    }
}
