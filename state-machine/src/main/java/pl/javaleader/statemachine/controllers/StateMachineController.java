package pl.javaleader.statemachine.controllers;

import org.springframework.statemachine.StateMachine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StateMachineController {

    @Autowired
    private StateMachine<String, String> stateMachine;

    @GetMapping("/sentEvent/{event}")
    public String sentEvent(@PathVariable("event") String event) {
        stateMachine.start();
        stateMachine.sendEvent(event);
        return stateMachine.getState().getId();
    }
}
