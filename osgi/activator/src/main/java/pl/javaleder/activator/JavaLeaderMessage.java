package pl.javaleder.activator;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;

public class JavaLeaderMessage implements BundleActivator {
    public void start(BundleContext ctx) {
        System.out.println("JavaLeader.pl activator start");
    }
    public void stop(BundleContext bundleContext) {
        System.out.println("JavaLeader.pl activator stop");
    }
}