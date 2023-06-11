package nl.inholland.exam.VedatTurk;

import lombok.extern.java.Log;
import nl.inholland.exam.VedatTurk.repository.DriverRepository;
import nl.inholland.exam.VedatTurk.service.DriverService;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@Log
@SpringBootApplication
public class VedatTurkApplication {

    public static void main(String[] args) {
        SpringApplication.run(VedatTurkApplication.class, args);
    }
}
