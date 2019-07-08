package bk.project;

import bk.project.domain.Driver;
import bk.project.domain.Rider;
import bk.project.repositories.DriversRepository;
import bk.project.services.DriverService;
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
public class ProjectApplicationTests {

    @Autowired
    private DriversRepository repository;
    @Autowired
    private DriverService service;
    
    @Before
    public void setUpMethod() throws Exception {
        GenericTest.executeOperation(DriverTest.INSERT_DRIVER);
    }
    @After
    public void delete() throws Exception {
        GenericTest.executeOperation(DriverTest.DELETE_DRIVER);
    }


    @Test
    public void contextLoads() {
        Driver driver = new Driver();
        driver.setNames("Abdul");
        driver.setPermitCard("458797");
        driver.setStatus(true);
        driver.setLatitude(-2.002746);
        driver.setLongitude(30.109818);
        driver.setGender("Male");
        service.createDriver(driver);
    }
    @Test
    public void FindAll(){
        service.allDrivers();
    }
    @Test
    public void FindbyId(){
        Driver driver = service.findById(6);
    }

}
