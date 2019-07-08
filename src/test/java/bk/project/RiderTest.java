package bk.project;

import com.ninja_squad.dbsetup.Operations;
import com.ninja_squad.dbsetup.operation.Operation;

public class RiderTest {
    public static Operation INSERT_RIDER=
            Operations.insertInto("rider")
                    .columns("id", "names","status","latitude","longitude")
                    .values(6, "Abdul",true,-2.002746,30.109818)
                    .build();
    public static Operation DELETE_RIDER =
            Operations.deleteAllFrom("rider");
}
//    private int id;
//    private boolean status;
//    private String names;
//    private double latitude;
//    private double longitude;