package bk.project.domain;

import lombok.Data;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Data
public class Trips {
    @Id
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
    private boolean isOpen;
    private int driverId;
    private int riderId;

}
