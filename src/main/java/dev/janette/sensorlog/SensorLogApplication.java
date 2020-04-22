package dev.janette.sensorlog;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class SensorLogApplication {

	public static void main(String[] args) {
		SpringApplication.run(SensorLogApplication.class, args);
	}

}
