package pl.javaleader.customactuatorendpoint.actuators;

import org.springframework.http.HttpStatus;

import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.WebEndpointResponse;
import org.springframework.boot.actuate.endpoint.web.annotation.EndpointWebExtension;
import org.springframework.stereotype.Component;

@Component
@EndpointWebExtension(endpoint = CustomEndPointOperation.class)
public class EndpointExtension {

    private final CustomEndPointOperation customEndPointOperation;

    public EndpointExtension(final CustomEndPointOperation customEndPointOperation) {
        this.customEndPointOperation = customEndPointOperation;
    }

    @WriteOperation
    WebEndpointResponse addItem(@Selector String text) {

        if (isNumeric(text)) {
            return new WebEndpointResponse<>(
                    HttpStatus.CONFLICT.value());
        }
        return new WebEndpointResponse<>(
                HttpStatus.CREATED.value());
    }

    public static boolean isNumeric(String str) {
        return str.matches("-?\\d+(\\.\\d+)?");
    }
}