package rs.raf.mstojanovic5623m.agpp.network.oebb.load;

import rs.raf.mstojanovic5623m.agpp.network.oebb.load.writers.EdgeWriter;
import rs.raf.mstojanovic5623m.agpp.network.oebb.load.writers.NodeWriter;
import rs.raf.mstojanovic5623m.agpp.network.oebb.load.writers.StationInfoWriter;
import rs.raf.mstojanovic5623m.agpp.network.oebb.load.writers.TranslationWriter;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.NetworkRepository;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.TranslationInfo;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;

public class Loader {

    private final Writer<StationInfo> stationInfoWriter = new StationInfoWriter();
    private final Writer<StationInfo> nodeWriter = new NodeWriter();

    private final Writer<TranslationInfo> translationInfoWriter = new TranslationWriter();
    private final Writer<TranslationInfo> edgeWriter = new EdgeWriter();

    public void load(NetworkRepository networkRepository, String path) {
        this.stationInfoWriter.writeAll(path, networkRepository.getStations());
        this.nodeWriter.writeAll(path, networkRepository.getStations());
        this.translationInfoWriter.writeAll(path, networkRepository.getTranslations());
        this.edgeWriter.writeAll(path, networkRepository.getTranslations());
    }
}
