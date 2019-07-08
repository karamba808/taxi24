package bk.project.services;


import bk.project.domain.Rider;

public class ServiceforAll {

    /*mthod for calculating distance between two points*/

    public double getDistanceFromLatLonInKm(double lat1,double lon1,double lat2,double lon2) {
        int R = 6371; // Radius of the earth in km
        double dLat = deg2rad(lat2-lat1);  // deg2rad below
        double dLon = deg2rad(lon2-lon1);
        double a =
                Math.sin(dLat/2) * Math.sin(dLat/2) +
                        Math.cos(deg2rad(lat1)) * Math.cos(deg2rad(lat2)) *
                                Math.sin(dLon/2) * Math.sin(dLon/2)
                ;
        double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1-a));
        double d = R * c; // Distance in km
        return d;
    }

    double  deg2rad(double deg) {
        return deg * (Math.PI/180);
    }

    public static void main(String[] args) {
        ServiceforAll s = new ServiceforAll();
        Rider rider = new Rider();
        double fg = Math.round(s.getDistanceFromLatLonInKm(rider.getLatitude(),rider.getLongitude(),-1.985751,30.103087));
        System.out.println("Distance is : "+fg);
    }

}
