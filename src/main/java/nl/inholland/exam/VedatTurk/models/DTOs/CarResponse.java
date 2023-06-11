package nl.inholland.exam.VedatTurk.models.DTOs;

import nl.inholland.exam.VedatTurk.models.Driver;

public record CarResponse (Long id, String brand, Driver driver, int topSpeed) {
}
