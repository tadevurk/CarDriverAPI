package nl.inholland.exam.VedatTurk.service;

import nl.inholland.exam.VedatTurk.models.Driver;
import nl.inholland.exam.VedatTurk.repository.DriverRepository;
import org.springframework.stereotype.Service;

@Service
public class DriverService {
    private final DriverRepository driverRepository;

    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public Driver saveDriver(Driver driver) {
        return driverRepository.save(driver);
    }

    public Driver findById(Long id) {
        return driverRepository.findById(id).orElse(null);
    }

    public void saveAllDrivers(Iterable<Driver> drivers) {
        driverRepository.saveAll(drivers);
    }

    public Iterable<Driver> findAllDrivers() {
        return driverRepository.findAll();
    }
}
