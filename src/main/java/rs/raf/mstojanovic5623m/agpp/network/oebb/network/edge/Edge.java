package rs.raf.mstojanovic5623m.agpp.network.oebb.network.edge;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.Writeable;

public class Edge implements Writeable, Edgeable {

    private final int source;
    private final int target;
    private final double weight;

    public Edge(int source, int target, double weight) {
        this.source = source;
        this.target = target;
        this.weight = weight;
    }

    @Override
    public Edge toEdge() {
        return this;
    }

    @Override
    public boolean isWriteable() {
        return true;
    }

    public int getSource() {
        return source;
    }

    public int getTarget() {
        return target;
    }

    public double getWeight() {
        return weight;
    }
}
