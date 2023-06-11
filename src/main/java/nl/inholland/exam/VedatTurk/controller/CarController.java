package nl.inholland.exam.VedatTurk.controller;

import nl.inholland.exam.VedatTurk.models.Car;
import nl.inholland.exam.VedatTurk.models.DTOs.CarRequest;
import nl.inholland.exam.VedatTurk.models.DTOs.CarResponse;
import nl.inholland.exam.VedatTurk.models.DTOs.TotalSpeedResponse;
import nl.inholland.exam.VedatTurk.service.CarService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/cars")
public class CarController {
    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @PostMapping()
    public ResponseEntity<CarResponse> addCar(@RequestBody CarRequest carRequest) {
        Car newCar = carService.saveCar(carRequest);
        CarResponse carResponse = buildCarResponse(newCar);
        return ResponseEntity.ok(carResponse);
    }

    // get the list of all cars according to the boolean value of wonBefore
    @GetMapping("/winners")
    public ResponseEntity<List<Car>> getCarsByWinners(@RequestParam("wonBefore") boolean wonBefore) {
        List<Car> cars;
        if (wonBefore) {
            cars = carService.findDriversWonBefore(true);
        } else {
            cars = carService.findDriversHaveNotWonBefore(true);
        }
        return ResponseEntity.ok(cars);
    }

    @GetMapping("totalSpeed")
    public ResponseEntity<TotalSpeedResponse> getTotalSpeed() {
        List<Car> cars = carService.findAllCars();
        TotalSpeedResponse totalSpeedResponse = buildTotalSpeedResponse(cars);
        return ResponseEntity.ok(totalSpeedResponse);
    }

    private TotalSpeedResponse buildTotalSpeedResponse(List<Car> cars) {
        return new TotalSpeedResponse(
                cars.stream().mapToInt(Car::getTopSpeed).sum()
        );
    }

    private CarResponse buildCarResponse(Car car) {
        return new CarResponse(
                car.getId(),
                car.getBrand(),
                car.getDriver(),
                car.getTopSpeed()
        );
    }
}
