package nl.inholland.exam.VedatTurk;

import lombok.extern.java.Log;
import nl.inholland.exam.VedatTurk.models.Car;
import nl.inholland.exam.VedatTurk.models.Driver;
import nl.inholland.exam.VedatTurk.models.Ranking;
import nl.inholland.exam.VedatTurk.service.CarService;
import nl.inholland.exam.VedatTurk.service.DriverService;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Collectors;

@Log
@SpringBootApplication
public class StartupRunner implements ApplicationRunner {
    final DriverService driverService;
    final CarService carService;

    public StartupRunner(DriverService driverService, CarService carService) {
        this.driverService = driverService;
        this.carService = carService;
    }

    @Override
    public void run(ApplicationArguments args) throws Exception {
        log.info("--- Exam Question 1 Completed ---");
        driverService.saveAllDrivers(
                Files.readAllLines(Paths.get("drivers.csv"))
                        .stream()
                        .map(line -> line.split(","))
                        .map(data -> new Driver(
                                data[0],
                                data[1],
                                Ranking.valueOf(data[2]),
                                Integer.parseInt(data[3]),
                                Boolean.parseBoolean(data[4])
                        ))
                        .collect(Collectors.toList())
        );
        driverService.findAllDrivers().forEach(System.out::println);

        log.info("--- Exam Question 2 Completed ---");
        readAllCars();
        log.info("--- Exam Question 4 Completed ---");
        log.info("--- Exam Question 5a Completed ---");
        log.info("--- Exam Question 5b Completed ---");
        log.info("--- Exam Question 6a Completed ---");
        log.info("--- Exam Question 6b Completed ---");
    }

    private void readAllCars() throws IOException {
        carService.saveAllCars(
                Files.readAllLines(Paths.get("cars.csv"))
                        .stream()
                        .map(line -> line.split(","))
                        .map(data -> new Car(
                                data[0],
                                driverService.findById(Long.parseLong(data[1]))
                        ))
                        .collect(Collectors.toList())
        );

        carService.findAllCars().forEach(System.out::println);
        log.info("--- Exam Question 3 Completed ---");
    }
}
