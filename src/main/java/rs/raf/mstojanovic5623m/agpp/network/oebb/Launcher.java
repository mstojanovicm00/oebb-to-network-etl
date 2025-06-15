package rs.raf.mstojanovic5623m.agpp.network.oebb;

import rs.raf.mstojanovic5623m.agpp.network.oebb.extract.Extracter;
import rs.raf.mstojanovic5623m.agpp.network.oebb.load.Loader;
import rs.raf.mstojanovic5623m.agpp.network.oebb.network.NetworkRepository;
import rs.raf.mstojanovic5623m.agpp.network.oebb.oebb.OEBBRepository;
import rs.raf.mstojanovic5623m.agpp.network.oebb.transform.Transformer;

public class Launcher {

    private static volatile Launcher launcher;

    public static Launcher getLauncher() {
        if (launcher == null) {
            synchronized (Launcher.class) {
                if (launcher == null) {
                    launcher = new Launcher();
                }
            }
        }
        return launcher;
    }

    private final Extracter extracter = new Extracter();
    private final Transformer transformer = new Transformer();
    private final Loader loader = new Loader();

    private Launcher() {

    }

    public void launch(String in, String out) {
        OEBBRepository oebbRepository = this.extracter.extract(in);
        NetworkRepository networkRepository = this.transformer.transform(oebbRepository);
        this.loader.load(networkRepository, out);
    }

}
