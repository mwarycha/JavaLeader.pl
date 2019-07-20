package pl.javaleader.customactuatorendpoint.actuators;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

// @WebEndpoint is exposed only over HTTP and not over JMX.
@Component
@WebEndpoint(id = "custom-list-operations-endpoint")
public class CustomEndPointOperation {

   List<String> stringList = new ArrayList();

   // GET
    // http://localhost:8080/actuator/custom-list-operations-endpoint
    @ReadOperation
    public String getAllItems() {
        return stringList.toString();
    }

    // POST
    // http://localhost:8080/actuator/custom-list-operations-endpoint/text?text=2
    // A Selector can be used on a parameter of an Endpoint method to indicate that the parameter is used to select a subset of the endpoint's data.
    @WriteOperation
    public WebEndpointResponse addItem(@Selector String text) {
        stringList.add(text);
        return new WebEndpointResponse<>(HttpStatus.CREATED.value());
    }

    // DELETE
    // http://localhost:8080/actuator/custom-list-operations-endpoint/text?text=2
    @DeleteOperation
    public void deleteItem(@Selector String text) {
        stringList.remove(text);
    }

    public List<String> getStringList() {
        return stringList;
    }

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }
}
