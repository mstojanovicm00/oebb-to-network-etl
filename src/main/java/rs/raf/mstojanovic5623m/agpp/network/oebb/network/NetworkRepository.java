package rs.raf.mstojanovic5623m.agpp.network.oebb.network;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.TranslationInfo;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;

import java.util.ArrayList;
import java.util.List;

public class NetworkRepository {

    private final List<StationInfo> stations = new ArrayList<>();
    private final List<TranslationInfo> translations = new ArrayList<>();

    public List<StationInfo> getStations() {
        return stations;
    }

    public List<TranslationInfo> getTranslations() {
        return translations;
    }
}
