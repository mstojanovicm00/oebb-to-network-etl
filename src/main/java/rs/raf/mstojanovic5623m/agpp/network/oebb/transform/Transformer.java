package rs.raf.mstojanovic5623m.agpp.network.oebb.transform;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.NetworkRepository;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.TranslationInfo;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.OEBBRepository;
import rs.raf.mstojanovic5623m.agpp.network.oebb.transform.coverters.StationConverter;
import rs.raf.mstojanovic5623m.agpp.network.oebb.transform.coverters.TranslationConverter;

import java.util.ArrayList;
import java.util.List;

public class Transformer {

    private final NetworkRepository networkRepository = new NetworkRepository();

    private final StationConverter stationConverter
            = new StationConverter();
    private final TranslationConverter translationConverter
            = new TranslationConverter(new ArrayList<>());

    public NetworkRepository transform(OEBBRepository oebbRepository) {
        List<StationInfo> stations = this.stationConverter.convertAll(
                oebbRepository.getStops());
        this.networkRepository.getStations().addAll(stations);

        this.translationConverter.getStations().addAll(stations);
        List<List<TranslationInfo>> translationLists
                = this.translationConverter.convertAll(oebbRepository.getTrips());
        List<TranslationInfo> translations = new ArrayList<>();
        for (List<TranslationInfo> translationList : translationLists)
            translations.addAll(translationList);
        this.networkRepository.getTranslations().addAll(translations);

        return this.networkRepository;
    }
}
