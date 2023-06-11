package nl.inholland.exam.VedatTurk.service;

import nl.inholland.exam.VedatTurk.models.Car;
import nl.inholland.exam.VedatTurk.models.DTOs.CarRequest;
import nl.inholland.exam.VedatTurk.repository.CarRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarService {
    private final CarRepository carRepository;
    private final DriverService driverService;

    public CarService(CarRepository carRepository, DriverService driverService) {
        this.carRepository = carRepository;
        this.driverService = driverService;
    }

    public List<Car> findAllCars() {
        return (List<Car>) carRepository.findAll();
    }

    public Car saveCar(CarRequest carRequest) {
        Car newCar = addCar(carRequest);
        return carRepository.save(newCar);
    }

    public Car findById(Long id) {
        return carRepository.findById(id).orElse(null);
    }
    public void saveAllCars(Iterable<Car> cars) {
        carRepository.saveAll(cars);
    }

    public List<Car> findDriversWonBefore(boolean wonBefore) {
        return carRepository.findByDriverWonBefore(wonBefore);
    }

    public List<Car> findDriversHaveNotWonBefore(boolean wonBefore) {
        return carRepository.findByDriverWonBefore(!wonBefore);
    }

    private Car addCar(CarRequest carRequest) {
        Car car = new Car();
        car.setBrand(carRequest.brand());
        car.setDriver(driverService.findById(carRequest.driverId()));
        car.setTopSpeed((int) (Math.random() * 50) + 250);
        return carRepository.save(car);
    }
}
