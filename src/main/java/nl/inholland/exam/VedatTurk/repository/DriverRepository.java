package nl.inholland.exam.VedatTurk.repository;

import nl.inholland.exam.VedatTurk.models.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository<Driver, Long>{

}
