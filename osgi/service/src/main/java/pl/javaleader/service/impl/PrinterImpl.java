package pl.javaleader.service.impl;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import org.osgi.framework.ServiceRegistration;
import pl.javaleader.service.Printer;
import java.util.Hashtable;

public class PrinterImpl implements Printer, BundleActivator {

    private ServiceReference<Printer> reference;
    private ServiceRegistration<Printer> registration;

    public void start(BundleContext context) throws Exception {
        System.out.println("Registering service. " + context);
        registration = context.registerService(Printer.class, new PrinterImpl(), new Hashtable<String, String>());
        reference = registration.getReference();
    }

    public void stop(BundleContext context) throws Exception {
        System.out.println("Unregistering service.");
        registration.unregister();
    }

    public String print(Object name) {
        return "[LOG] " + name;
    }
}