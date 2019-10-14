package pl.javaleader.gracefulshutdown.components;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextClosedEvent;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.springframework.stereotype.Component;

@Component
public class GracefulShutdown implements ApplicationListener<ContextClosedEvent> {

    private final TomcatGracefulShutdownConnector gracefulShutdown;

    public GracefulShutdown(final TomcatGracefulShutdownConnector gracefulShutdown) {
        this.gracefulShutdown = gracefulShutdown;
    }

    @Override
    public void onApplicationEvent(final ContextClosedEvent contextClosedEvent) {
        try {
            final ThreadPoolExecutor threadPoolExecutor = gracefulShutdown.threadPoolExecutor().orElseThrow(() -> new IllegalStateException());
            threadPoolExecutor.shutdown();
            if(!threadPoolExecutor.awaitTermination(20, TimeUnit.SECONDS)) {
                System.out.println("time out...");
            } else {
                System.out.println("graceful activated");
            }
        } catch(InterruptedException ex) {
            Thread.currentThread().interrupt();
        }
    }
}