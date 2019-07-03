package bk.project.controllers;


import bk.project.ResponseBean;
import bk.project.domain.Rider;
import bk.project.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/rider")
public class RiderController {
    @Autowired
    private RiderService riderService;
    /*method for saving */
    @PostMapping("/")
    public ResponseEntity<Object> createDriver(@RequestBody Rider rider){
        ResponseBean responseBean = new ResponseBean();
        try {
                responseBean.setCode(200);
                responseBean.setDescription("saved");
                responseBean.setObject(riderService.createDriver(rider));

        }catch (Exception e){
            e.printStackTrace();
            responseBean.setCode(300);
            responseBean.setDescription("Permit card exist");
            responseBean.setObject(null);
        }
        return new ResponseEntity<Object>(responseBean, HttpStatus.OK);
    }
    /*get all */
    @GetMapping("/")
    public ResponseEntity<Object> AllDriver(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(200);
        responseBean.setDescription("All driver");
        responseBean.setObject(riderService.allRivers());
        return new ResponseEntity<Object>(responseBean,HttpStatus.OK);
    }
    /*get get by id */
    @GetMapping("/{id}")
    public ResponseEntity<Object> findById(@PathVariable("id") int id){
        ResponseBean responseBean = new ResponseBean();
        Rider rider = riderService.findById(id);
        try {
            if(rider != null){
                responseBean.setCode(200);
                responseBean.setDescription("rider found");
                responseBean.setObject(riderService.findById(rider.getId()));
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

//    @GetMapping("/{id}/closest")
//    public ResponseEntity<Object> closestDriver(@PathVariable("id") int id){
//        ResponseBean responseBean = new ResponseBean();
//        Rider rider = riderService.findById(id);
//        try {
//            if(rider != null){
//                responseBean.setCode(200);
//                responseBean.setDescription("rider found");
//                responseBean.setObject(riderService.ClosestDriver(rider.getLat(),rider.getLng()));
//            }else{
//                responseBean.setCode(350);
//                responseBean.setDescription("Not found");
//                responseBean.setObject(null);
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//            responseBean.setCode(300);
//            responseBean.setDescription("Not found");
//            responseBean.setObject(null);
//        }
//        return new ResponseEntity<Object>(responseBean,HttpStatus.OK);
//    }
}
