package sanal.mert.runnerz;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import sanal.mert.runnerz.run.Location;
import sanal.mert.runnerz.run.Run;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

@SpringBootApplication
public class RunnerzApplication {
	private static final Logger log = LoggerFactory.getLogger(RunnerzApplication.class);

	public static void main(String[] args) {
		SpringApplication.run(RunnerzApplication.class, args);
	}

	@Bean
	CommandLineRunner runner() {
		return args -> {
			LocalDateTime startTime = LocalDateTime.now();
			LocalDateTime endTime = startTime.plus(1, ChronoUnit.HOURS);

			Run run = new Run(1, "First run", startTime, endTime, 5, Location.OUTDOOR);
			log.info("Run "+ run);
		};
	}
}
