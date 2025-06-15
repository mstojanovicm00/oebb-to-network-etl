package rs.raf.mstojanovic5623m.agpp.network.oebb.network.node;

import rs.raf.mstojanovic5623m.agpp.network.oebb.network.Writeable;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.utilities.PrimaryKeyUtils;

public class Node implements Writeable {

    private int id;
    private final String label;

    private boolean writeable = false;

    public Node(String label) {
        this.id = 0;
        this.label = label;
    }

    public void setId() {
        this.id = PrimaryKeyUtils.generateNextKey("node");
    }

    @Override
    public boolean isWriteable() {
        return this.writeable;
    }

    public void setWriteable(boolean writeable) {
        this.writeable = writeable;
    }

    @Override
    public String toString() {
        return this.label;
    }

    public int getId() {
        return id;
    }

    public String getLabel() {
        return label;
    }

}
