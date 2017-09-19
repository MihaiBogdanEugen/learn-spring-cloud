package ro.mbe.learn.springcloud.tasks;

import org.springframework.boot.CommandLineRunner;

public class TollProcessingTask implements CommandLineRunner {

    private static final String template = "Station ID is %s, plate is %s, timestamp is %s";

    @Override
    public void run(String...strings) throws Exception {

        if (strings != null && strings.length == 3){

            String stationId = strings[0];
            String licensePlate = strings[1];
            String timestamp = strings[2];

            System.out.println(String.format(template, stationId, licensePlate, timestamp));
        }

        System.out.println("Task completed.");
    }
}
