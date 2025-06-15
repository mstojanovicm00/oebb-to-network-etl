package rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.node.StationInfo;

public class EdgeBuilder implements Edgeable {

    private final StationInfo from;
    private final StationInfo to;
    private final double weight;

    public EdgeBuilder(StationInfo from, StationInfo to, double weight) {
        this.from = from;
        this.to = to;
        this.weight = weight;
    }

    @Override
    public Edge toEdge() {
        return new Edge(this.from.getNode().getId(), this.to.getNode().getId(), this.weight);
    }
}
