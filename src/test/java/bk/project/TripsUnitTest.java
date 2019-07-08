package bk.project;

import bk.project.domain.Trips;
import bk.project.services.ServiceforAll;
import bk.project.services.TripsService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

@RunWith(SpringRunner.class)
@SpringBootTest
public class TripsUnitTest {
    @Autowired
    private TripsService tripsService;
    private ServiceforAll serviceforAll = new ServiceforAll();

    @Before
    public void setUpMethod() throws Exception {
        GenericTest.executeOperation(TripsTest.INSERT_DRIVER_RIDER);
    }
    @After
    public void delete() throws Exception {
        GenericTest.executeOperation(TripsTest.DELETE_TRIPS);
    }

    @Test
    public void contextLoads() {
        Trips trips = new Trips();
        trips.setStatus(1);
        trips.setFromLat(994168);
        trips.setFromLng(12699);
        trips.setDistance(serviceforAll.getDistanceFromLatLonInKm(-1.994168,30.12699,-1.985751,30.103087));
        trips.setToLat(-1.985751);
        trips.setToLng(30.103087);
        trips.setDoneAt(new Date().toString());
        trips.setRiderId(6);
        trips.setDriverId(6);
    }
}
