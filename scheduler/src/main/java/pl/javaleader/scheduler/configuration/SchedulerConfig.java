package pl.javaleader.scheduler.configuration;

import org.springframework.scheduling.annotation.SchedulingConfigurer;
import org.springframework.scheduling.config.ScheduledTaskRegistrar;
import pl.javaleader.scheduler.tasks.ScheduledTaskLogger;
import java.time.LocalDateTime;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;

@Configuration
@EnableScheduling
public class SchedulerConfig implements SchedulingConfigurer {

    @Bean
    public ScheduledTaskLogger SchedulerTaskLogger() {
        return new ScheduledTaskLogger();
    }

    @Override
    public void configureTasks(ScheduledTaskRegistrar taskRegistrar) {
        final LocalDateTime dateChange = LocalDateTime.now().plusSeconds(20);
        taskRegistrar.addFixedRateTask(() -> {
            if (LocalDateTime.now().isAfter(dateChange)) {
                SchedulerTaskLogger().executeTask2();
            }
        }, 1000);
    }
}