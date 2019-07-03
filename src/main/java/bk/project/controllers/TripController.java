package bk.project.controllers;



import bk.project.ResponseBean;
import bk.project.domain.Trips;
import bk.project.services.TripsService;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.io.IOException;

@RestController
@RequestMapping("/trip")
public class TripController {
    OkHttpClient client = new OkHttpClient();
    @Autowired
    private TripsService tripsService;

    @PostMapping("/")
    public ResponseEntity<Object> createDriver(@RequestBody Trips trip){
        ResponseBean responseBean = new ResponseBean();
        try {
            String response = this.calculate(trip.getFromLat(), trip.getFromLng(), trip.getToLat(), trip.getToLng());
            System.out.println(response);
            JSONParser parser = new JSONParser();
            Object obj = parser.parse(response);
            JSONObject jsonobj=(JSONObject)obj;
            JSONArray dist=(JSONArray)jsonobj.get("rows");
            JSONObject obj2 = (JSONObject)dist.get(0);
            JSONArray disting=(JSONArray)obj2.get("elements");
            JSONObject obj3 = (JSONObject)disting.get(0);
            JSONObject obj4=(JSONObject)obj3.get("distance");
            //JSONObject duration=(JSONObject)obj3.get("duration");
            String distance = (String) obj4.get("text");
            double realDistance =Double.parseDouble(distance.substring(0, distance.length()-3));
            trip.setDistance(realDistance);
            responseBean.setCode(200);
            responseBean.setDescription("saved");
            responseBean.setObject(tripsService.createTrip(trip));

        }catch (Exception e){
            e.printStackTrace();
            responseBean.setCode(300);
            responseBean.setDescription(" There is an error");
            responseBean.setObject(null);
        }
        return new ResponseEntity<Object>(responseBean, HttpStatus.OK);
    }

    @GetMapping("/trips/{id}")
    public ResponseEntity<Object> TripbyId(@RequestParam("id") int id){
        Trips trips = tripsService.findOne(id);
        ResponseBean responseBean = new ResponseBean();
        try {
            if(trips != null){
                responseBean.setCode(200);
                responseBean.setDescription("Trip founded");
                responseBean.setObject(trips);
            }else{
                responseBean.setCode(300);
                responseBean.setDescription("Not Found");
                responseBean.setObject(null);
            }
        }catch (Exception e){
            e.printStackTrace();
            responseBean.setCode(300);
            responseBean.setDescription("Not Found");
            responseBean.setObject(null);
        }

        return new ResponseEntity<Object>(responseBean,HttpStatus.OK);
    }

    @GetMapping("/completed")
    public ResponseEntity<Object> completedTrip(){
        ResponseBean responseBean = new ResponseBean();
        responseBean.setCode(200);
        responseBean.setDescription("All Completed trips");
        responseBean.setObject(tripsService.completedTrips());
        return new ResponseEntity<Object>(responseBean,HttpStatus.OK);
    }

    public String calculate(double fromLat,double fromLng,double toLat,double toLng) throws IOException {
        String url = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+fromLat+","+fromLng+"&destinations="+toLat+","+toLng+"&key=AIzaSyDUYbTR-3PDWPhgxjENs4yf35g2eHc641s";
        Request request = new Request.Builder().url(url).build();

        Response response = client.newCall(request).execute();
        return response.body().string();
    }
}
