package bk.project;

import bk.project.domain.Rider;
import bk.project.services.RiderService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RiderUnitTest {
    @Autowired
    private RiderService riderService;

    @Before
    public void setUpMethod() throws Exception {
        GenericTest.executeOperation(RiderTest.INSERT_RIDER);
    }
    @After
    public void delete() throws Exception {
        GenericTest.executeOperation(RiderTest.DELETE_RIDER);
    }
    @Test
    public void contextLoads() {
        Rider rider = new Rider();
        rider.setNames("Kevin");
        rider.setLongitude(30.109818);
        rider.setLatitude(-2.002746);
        rider.setStatus(true);
        riderService.createDriver(rider);
    }
}
