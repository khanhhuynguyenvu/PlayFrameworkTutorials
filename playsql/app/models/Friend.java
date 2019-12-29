package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.util.Random;

@Entity
public class Friend {

    @Id
    private long id;
    @Column
    private String name;
    @Column
    private String surname;

    // mock
    public Friend(long id) {
        this.id = id;
        this.name = "name" + new Random().nextInt(1234);
        this.surname = "surname" + new Random().nextInt(1234);
    }

    public Friend() { }

    // getters and setters
}
