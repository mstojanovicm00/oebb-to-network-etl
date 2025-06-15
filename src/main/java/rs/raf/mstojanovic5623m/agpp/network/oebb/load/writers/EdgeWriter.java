package rs.raf.mstojanovic5623m.agpp.network.oebb.load.writers;

import rs.raf.mstojanovic5623m.agpp.network.oebb.load.Writer;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.Edge;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.Edgeable;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge.TranslationInfo;

public class EdgeWriter implements Writer<TranslationInfo> {
    @Override
    public String[] write(TranslationInfo item) {
        Edgeable edge = item.getEdge();
        edge = edge.toEdge();
        item.setEdge(edge);
        return new String[] {"" + ((Edge) edge).getSource(),
                "" + ((Edge) edge).getTarget(),
                "" + ((Edge) edge).getWeight()};
    }

    @Override
    public String file(String dir) {
        return dir + "/edges.csv";
    }

    @Override
    public String[] headers() {
        return new String[] {"Source", "Target", "Weight"};
    }
}
