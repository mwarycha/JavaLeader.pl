package pl.javaleader.spring.dsl;

import org.apache.camel.builder.RouteBuilder;

public class CamelContextBck extends RouteBuilder {

    private static final String SOURCE_FOLDER  = "src/main/java/pl/javaleader";
    private static final String BCK_FOLDER     = "src/main/java/bck";

    @Override
    public void configure() throws Exception {
        from("file://" + SOURCE_FOLDER + "?noop=true&recursive=true").process(
                new ProcessFiles()).to("file://" + BCK_FOLDER);
    }
}