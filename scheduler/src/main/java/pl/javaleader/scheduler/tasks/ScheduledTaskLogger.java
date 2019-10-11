package pl.javaleader.scheduler.tasks;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.scheduling.annotation.Schedules;
import org.springframework.stereotype.Component;

@Component
public class ScheduledTaskLogger {

    private static final Logger log = LoggerFactory.getLogger(ScheduledTaskLogger.class);

    @Scheduled(fixedRate = 1000, zone ="Europe/Warsaw")
    public void executeTask1() {

        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        log.info("Task 1 executed at {}", now);
    }

    @Schedules({
            @Scheduled(cron = "15 * * * * *"),
            @Scheduled(fixedDelay = 5000)
    })
    public void executeTask2() {
        String now = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS"));
        log.info("Task 2 executed at {}", now);
    }
}