package bk.project.controllers;


import bk.project.ResponseBean;
import bk.project.domain.Driver;
import bk.project.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/driver")
public class DriverController {
    @Autowired
    private DriverService driverService;
    @PostMapping("/")
    public ResponseEntity<Object> createDriver(@RequestBody Driver driver){
        ResponseBean responseBean = new ResponseBean();
        try {
            if(!driver.getPermitCard().isEmpty()){
                responseBean.setCode(200);
                responseBean.setDescription("Driver saved");
                responseBean.setObject(driverService.createDriver(driver));
            }
        }catch (Exception e){
            e.printStackTrace();
            responseBean.setCode(300);
            responseBean.setDescription("Permit card exist");
            responseBean.setObject(null);
        }
        return new ResponseEntity<Object>(responseBean,HttpStatus.OK);
    }
    @GetMapping("/")
    public ResponseEntity<Object> AllDriver(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(200);
        responseBean.setDescription("All drivers");
        responseBean.setObject(driverService.allDrivers());
        return new ResponseEntity<Object>(responseBean,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id){
        ResponseBean responseBean = new ResponseBean();
        Driver driver = driverService.findById(id);
        try {
            if(driver != null){
                responseBean.setCode(200);
                responseBean.setDescription("Driver found");
                responseBean.setObject(driverService.findById(driver.getId()));
            }else{
                responseBean.setCode(300);
                responseBean.setDescription("Not found");
                responseBean.setObject(null);
            }
        }catch (Exception e){
            responseBean.setCode(300);
            responseBean.setDescription("Not found");
            responseBean.setObject(null);
        }
        return new ResponseEntity<Object>(responseBean,HttpStatus.OK);
    }

    @GetMapping("/available")
    public ResponseEntity<Object> findByDriverAround(){
        ResponseBean responseBean = new ResponseBean();
        try {
                responseBean.setCode(200);
                responseBean.setDescription("Available Drivers");
                responseBean.setObject(driverService.availableDriver(-1.959170,30.086825));

        }catch (Exception e){
            responseBean.setCode(300);
            responseBean.setDescription("Not found");
            responseBean.setObject(null);
        }
        return new ResponseEntity<Object>(responseBean,HttpStatus.OK);
    }
}
