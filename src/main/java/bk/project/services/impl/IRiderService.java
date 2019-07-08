package bk.project.services.impl;

import bk.project.domain.Driver;
import bk.project.domain.Rider;
import bk.project.repositories.DriversRepository;
import bk.project.repositories.RiderRepository;
import bk.project.services.RiderService;
import bk.project.services.ServiceforAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IRiderService implements RiderService {
    @Autowired
    private RiderRepository riderRepository;
    @Autowired
    private DriversRepository driversRepository;
    private ServiceforAll serviceforAll = new ServiceforAll();
    private double dist;

    @Override
    public Rider createDriver(Rider rider) {
        return riderRepository.save(rider);
    }

    @Override
    public List<Rider> allRivers() {
        return riderRepository.findAll();
    }

    @Override
    public Rider findById(int id) {
        return riderRepository.findById(id).get();
    }

    @Override
    public List<Driver> searcharound(double latitude , double longitude) {

        List<Driver>list = new ArrayList();
        List<Driver>alldriver = driversRepository.findAll();
        for (Driver d : alldriver){
            dist = serviceforAll.getDistanceFromLatLonInKm(latitude , longitude ,d.getLatitude(),d.getLongitude());
            if(dist < 3){
                list.add(d);
            }
        }
        return list;
    }
}
