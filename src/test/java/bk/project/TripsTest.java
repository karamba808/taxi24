package bk.project;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;


public class TripsTest {
    public static Operation INSERT_TRIPS=
            Operations.insertInto("trips")
                    .columns("id", "status","from_lat","from_lng","distance","to_lat","to_lng","driver_id","rider_id","done_at","completed_at")
                    .values(6, 1,-2.002746,30.109818,3,-1.985751,30.103087,6,6,"Mon Jul 08 11:31:00 CAT 2019",null)
                    .build();
    public static Operation INSERT_DRIVER_RIDER
            = Operations.sequenceOf(DriverTest.INSERT_DRIVER, RiderTest.INSERT_RIDER);
    public static Operation DELETE_TRIPS =
            Operations.deleteAllFrom("trips");

}
//    private int id;
//
//    /*1 active
//      2 completed
//      3 Canceled
//     */
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