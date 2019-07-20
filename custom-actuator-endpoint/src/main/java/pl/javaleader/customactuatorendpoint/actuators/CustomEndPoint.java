package pl.javaleader.customactuatorendpoint.actuators;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.stereotype.Component;

//  any methods annotated with @ReadOperation, @WriteOperation, or @DeleteOperation are automatically exposed over JMX and, in a web application, over HTTP as well.
@Endpoint(id="custom-endpoint")
@Component
public class CustomEndPoint {
    @ReadOperation
    public String mypoint(){
        return "Hello World" ;
    }
}