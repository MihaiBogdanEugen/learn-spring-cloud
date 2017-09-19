package ro.mbe.learn.springcloud.tasks;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TaskConfig {

    @Bean
    public TaskProcessor taskProcessor() {
        return new TaskProcessor();
    }
}
