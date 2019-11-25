package pl.javaleader.aspectaop.controllers;

import pl.javaleader.aspectaop.service.ServiceBean;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ServiceRestController {

    private final ServiceBean serviceBean;

    public ServiceRestController(ServiceBean serviceBean) {
        this.serviceBean = serviceBean;
    }

    @GetMapping("/")
    public String getServiceMsg() {
      return serviceBean.getMsg();
    }
}
