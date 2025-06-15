package rs.raf.mstojanovic5623m.agpp.network.oebb.network.node;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.Writeable;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.TranslationInfo;

import java.util.ArrayList;
import java.util.List;

public class StationInfo implements Writeable {

    private final String dataset = "oebb-2025";
    private final String id;
    private final String code;
    private final String name;
    private final String description;
    private final double latitude;
    private final double longitude;
    private final String url;
    private final Node node;
    private final List<TranslationInfo> translationsIn = new ArrayList<>();
    private final List<TranslationInfo> translationsOut = new ArrayList<>();

    public StationInfo(String id, String code, String name, String description, double latitude, double longitude, String url, Node node) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.description = description;
        this.latitude = latitude;
        this.longitude = longitude;
        this.url = url;
        this.node = node;
    }

    public boolean isWriteable() {
        if (!this.translationsIn.isEmpty() || !this.translationsOut.isEmpty()) {
            this.node.setWriteable(true);
            return true;
        }
        this.node.setWriteable(false);
        return false;
    }

    public void addInTranslation(TranslationInfo translation) {
        this.translationsIn.add(translation);
        this.isWriteable();
    }

    public void addOutTranslation(TranslationInfo translation) {
        this.translationsOut.add(translation);
        this.isWriteable();
    }

    @Override
    public String toString() {
        return "StationInfo{" +
                "dataset='" + dataset + '\'' +
                ", id='" + id + '\'' +
                ", code='" + code + '\'' +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", url='" + url + '\'' +
                ", node=" + node +
                '}';
    }

    public String getDataset() {
        return dataset;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getLatitude() {
        return latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public String getUrl() {
        return url;
    }

    public Node getNode() {
        return node;
    }

    public static class StationInfoBuilder {
        private String id = "";
        private String code = "";
        private String name = "";
        private String description = "";
        private double latitude = 0.0;
        private double longitude = 0.0;
        private String url = "";

        public StationInfo toStationInfo() {
            return new StationInfo(id, code, name, description, latitude, longitude, url,
                    this.createNode());
        }

        private Node createNode() {
            return new Node(this.name);
        }

        public StationInfoBuilder setId(String id) {
            this.id = id;
            return this;
        }

        public StationInfoBuilder setCode(String code) {
            this.code = code;
            return this;
        }

        public StationInfoBuilder setName(String name) {
            this.name = name;
            return this;
        }

        public StationInfoBuilder setDescription(String description) {
            this.description = description;
            return this;
        }

        public StationInfoBuilder setLatitude(double latitude) {
            this.latitude = latitude;
            return this;
        }

        public StationInfoBuilder setLongitude(double longitude) {
            this.longitude = longitude;
            return this;
        }

        public StationInfoBuilder setUrl(String url) {
            this.url = url;
            return this;
        }
    }
}
