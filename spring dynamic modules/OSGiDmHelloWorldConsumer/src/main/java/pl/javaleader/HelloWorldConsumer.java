package pl.javaleader;

import pl.javaleader.ws.HelloWorldService;
import javax.swing.Timer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HelloWorldConsumer implements ActionListener {

    private final Timer timer = new Timer(1000, this);
    private final HelloWorldService service;

    public HelloWorldConsumer(HelloWorldService service) {
        super();

        this.service = service;
    }

    public void startTimer(){
        timer.start();
    }

    public void stopTimer() {
        timer.stop();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        service.hello();
    }
}