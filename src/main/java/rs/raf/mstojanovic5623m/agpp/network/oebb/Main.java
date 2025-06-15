package rs.raf.mstojanovic5623m.agpp.network.oebb;

public class Main {
    public static void main(String[] args) {
        String in = "/home/mihajlo-stojanovic/Faculty/Master/Usmerenja/" +
                "Automatsko generisanje plana putovanja/00 Podaci/" +
                "GTFS_OP_2025_obb OEBB";
        String out = "/home/mihajlo-stojanovic/Faculty/Master/Usmerenja/" +
                "Automatsko generisanje plana putovanja/00 Podaci/Warehouse/" +
                "network";
        Launcher.getLauncher().launch(in, out);
    }
}
