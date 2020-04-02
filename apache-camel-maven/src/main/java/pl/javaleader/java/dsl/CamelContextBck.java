package pl.javaleader.java.dsl;

import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;

public class CamelContextBck {

    private static final long   DURATION_MILIS = 10000;
    private static final String SOURCE_FOLDER  = "src/main/java/pl/javaleader";
    private static final String BCK_FOLDER     = "src/main/java/bck";

    public static void createBck() throws Exception {

        CamelContext camelContext = new DefaultCamelContext();
        camelContext.addRoutes(new RouteBuilder() {
            @Override
            public void configure() throws Exception {
                from("file://" + SOURCE_FOLDER + "?noop=true&recursive=true").process(
                        new ProcessFiles()).to("file://" + BCK_FOLDER);
            }
        });
        camelContext.start();
        Thread.sleep(DURATION_MILIS);
        camelContext.stop();
    }

}
