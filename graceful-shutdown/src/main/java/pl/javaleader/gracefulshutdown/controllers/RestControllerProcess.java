package pl.javaleader.gracefulshutdown.controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RestControllerProcess {

    @GetMapping("/process-1")
    String longJob() throws InterruptedException {
        Thread.sleep(15_000);
        return "Done";
    }
    @GetMapping("/process-2")
    String veryLongJob() throws InterruptedException {
        Thread.sleep(25_000);
        return "Done";
    }

}
