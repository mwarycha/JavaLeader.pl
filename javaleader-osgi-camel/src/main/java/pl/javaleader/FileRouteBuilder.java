package pl.javaleader;

import org.apache.camel.builder.RouteBuilder;

public class FileRouteBuilder extends RouteBuilder {
    public void configure() {
        from("file:C:\\Users\\EMAWARY\\Downloads\\in?noop=true").to("file:C:\\Users\\EMAWARY\\Downloads\\out");
    }
}