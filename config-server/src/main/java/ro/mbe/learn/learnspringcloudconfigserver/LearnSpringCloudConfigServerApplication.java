package ro.mbe.learn.learnspringcloudconfigserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class LearnSpringCloudConfigServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(LearnSpringCloudConfigServerApplication.class, args);
    }
}
