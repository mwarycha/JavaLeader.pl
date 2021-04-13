package pl.javaleader.LoadBalanced.controllers;

import org.springframework.web.client.RestTemplate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RibbonClient(name = "master")
public class MasterController {

  @Autowired
  RestTemplate restTemplate;

  @GetMapping("/worker")
  public String getWorkerPortInstance() {
        String url = "http://master/getWorker/port";
        String port = "[port] : " + restTemplate.getForObject(url, String.class);
        return port;
  }
}