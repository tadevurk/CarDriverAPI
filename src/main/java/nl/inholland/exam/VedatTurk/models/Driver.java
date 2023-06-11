package nl.inholland.exam.VedatTurk.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@Data
@AllArgsConstructor
public class Driver {

    @Id
    @SequenceGenerator(name = "driver_sequence", initialValue =1000001, allocationSize = 1)
    @GeneratedValue(generator = "driver_sequence")
    private Long id;

    private String firstName;
    private String lastName;
    private Ranking ranking;
    private int age;
    private boolean wonBefore;

    public Driver(String firstName, String lastName, Ranking ranking, int age, boolean wonBefore) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.ranking = ranking;
        this.age = age;
        this.wonBefore = wonBefore;
    }
}
