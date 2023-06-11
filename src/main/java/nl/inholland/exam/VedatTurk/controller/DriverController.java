package nl.inholland.exam.VedatTurk.controller;

import lombok.extern.java.Log;
import nl.inholland.exam.VedatTurk.service.DriverService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/drivers")
@Log
public class DriverController {

    private final DriverService driverService;

    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/{driverId}")
    public ResponseEntity getDriverById(@PathVariable Long driverId) {
        return ResponseEntity.ok(driverService.findById(driverId));
    }
}
