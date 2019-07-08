package bk.project.domain;

import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data
public class Trips {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /*1 active
      2 completed
      3 Canceled
     */
    private int status;
    private double fromLat;
    private double fromLng;
    private double distance;
    private double toLat;
    private double toLng;
    private int driverId;
    private int riderId;
    private String doneAt = new Date().toString();
    @Column(nullable = true)
    private String completedAt;

}
