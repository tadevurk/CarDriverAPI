package nl.inholland.exam.VedatTurk.models;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Car {
    @Id
    @SequenceGenerator(name = "car_sequence", initialValue = 9000001, allocationSize = 1)
    @GeneratedValue(generator = "car_sequence")
    private Long id;


    private String brand;
    private int topSpeed;
    @OneToOne
    public Driver driver;

    public Car(String brand, Driver driver) {
        this.brand = brand;
        this.topSpeed = (int) (Math.random() * 50) + 250;
        this.driver = driver;
    }
}
