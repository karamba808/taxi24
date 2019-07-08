package bk.project.domain;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Date;

@Entity
@Data
public class Invoice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String doneAt;
    private int tripsId;
    private int driverId;
    private String driverName;
    private double uniPrice = 300;
    private double distance;
    private double totolPrice;
}
