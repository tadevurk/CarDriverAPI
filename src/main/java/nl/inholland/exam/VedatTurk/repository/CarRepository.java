package nl.inholland.exam.VedatTurk.repository;

import nl.inholland.exam.VedatTurk.models.Car;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends CrudRepository<Car, Long> {
    @Query(value = "SELECT c FROM Car c JOIN c.driver d WHERE d.wonBefore = :wonBefore")
    List<Car> findByDriverWonBefore(@Param("wonBefore") boolean wonBefore);

}
