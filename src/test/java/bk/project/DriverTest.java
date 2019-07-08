package bk.project;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

public class DriverTest {
    public static Operation INSERT_DRIVER=
            Operations.insertInto("driver")
                    .columns("id", "names","gender","permit_card","status","latitude","longitude")
                    .values(6, "Abdul","Male","17896",true,-2.002746,30.109818)
                    .build();
    public static Operation DELETE_DRIVER =
            Operations.deleteAllFrom("driver");
}

//    private int status;
//    private double fromLat;
//    private double fromLng;
//    private double distance;
//    private double toLat;
//    private double toLng;
//    private int driverId;
//    private int riderId;
//    private String doneAt = new Date().toString();
//    @Column(nullable = true)
//    private String completedAt;