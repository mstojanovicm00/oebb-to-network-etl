package rs.raf.mstojanovic5623m.agpp.network.oebb.load.writers;

import rs.raf.mstojanovic5623m.agpp.network.oebb.load.Writer;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.Node;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;

public class NodeWriter implements Writer<StationInfo> {
    @Override
    public String[] write(StationInfo item) {
        Node node = item.getNode();
        node.setId();
        return new String[] {"" + node.getId(), node.getLabel()};
    }

    @Override
    public String file(String dir) {
        return dir + "/nodes.csv";
    }

    @Override
    public String[] headers() {
        return new String[] {"Id", "Label"};
    }
}
