package controller;

import java.util.*;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.client.ClientConfig;
import static utils.UtilsClass.*;

public class BingoController {

    public static void main(String[] args) {

        ClientConfig config = new ClientConfig();

        Client client = ClientBuilder.newClient(config);

        WebTarget target = client.target(getBaseURI());

        String response = target.path("/api").
                            path("/bingo/get/3").
                            request().
                            accept(MediaType.APPLICATION_JSON).
                            get(String.class);

       Map<Object, Object> data = getMapFromJson(response);
    }
}