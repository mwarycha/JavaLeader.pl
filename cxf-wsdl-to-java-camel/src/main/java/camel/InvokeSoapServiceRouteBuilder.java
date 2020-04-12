package camel;

import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.cxf.common.message.CxfConstants;

public class InvokeSoapServiceRouteBuilder extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        from("timer:foo?period=1000").routeId("myRoute")

                .bean(GetAdditionRequestBuilder.class, "getSubstraction")

                .setHeader(CxfConstants.OPERATION_NAME,      constant("subtraction"))
                .setHeader(CxfConstants.OPERATION_NAMESPACE, constant("http://ws.javaleader.pl/"))

                .log("ReqLog ${body}")

                .process(new Processor() {
                    public void process(Exchange e) {
                        log.debug(e.getIn().getBody() + "body from processor");
                    }
                })

                .to("cxf://http://localhost:8181/cxf/calcService"
                        + "?serviceClass=pl.javaleader.ws.Calculator"
                        + "&wsdlURL=http://localhost:8181/cxf/calcService?wsdl")

                 .log("ResLog ${body}");
    }
}

