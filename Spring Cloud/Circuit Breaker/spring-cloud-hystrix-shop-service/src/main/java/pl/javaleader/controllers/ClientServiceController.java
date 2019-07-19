package pl.javaleader.controllers;

import pl.javaleader.service.ClientServiceDelegate;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

// http://localhost:9099/hystrix        - dashboard circuit breaker
// http://localhost:9099/hystrix.stream -  meaningful dynamic visual representation of the circuit being monitored by the Hystrix component

@RestController
public class ClientServiceController {

    @Autowired
    ClientServiceDelegate clientServiceDelegate;

    @RequestMapping(value = "/getClientDetails/{client}", method = RequestMethod.GET)
    public String getClient(@PathVariable String client) {
        return clientServiceDelegate.callClientServiceAndGetData(client);
    }
}