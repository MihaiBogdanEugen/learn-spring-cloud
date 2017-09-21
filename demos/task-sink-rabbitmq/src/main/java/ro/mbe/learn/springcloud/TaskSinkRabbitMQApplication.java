package ro.mbe.learn.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.task.launcher.annotation.EnableTaskLauncher;

@SpringBootApplication
@EnableTaskLauncher
public class TaskSinkRabbitMQApplication {

    public static void main(String[] args) {
        SpringApplication.run(TaskSinkRabbitMQApplication.class, args);
    }
}
