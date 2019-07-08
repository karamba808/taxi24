package bk.project.services.impl;


import bk.project.domain.Driver;
import bk.project.repositories.DriversRepository;
import bk.project.services.DriverService;
import bk.project.services.ServiceforAll;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class IDriverService implements DriverService {
    @Autowired
    private DriversRepository driversRepository;
    private ServiceforAll serviceforAll = new ServiceforAll();
    private double distance;

    @Override
    public Driver createDriver(Driver driver) {
        return driversRepository.save(driver);
    }

    @Override
    public List<Driver> allDrivers() {
        return driversRepository.findAll();
    }

    @Override
    public List<Driver> availableDriver(boolean status) {
        return driversRepository.findAllByStatus(status);
    }

    @Override
    public Driver findById(int id) {
        return driversRepository.findById(id).get();
    }

    @Override
    public List<Driver> availableDriver(double latitude, double longitude) {
        List<Driver>list = new ArrayList();
        List<Driver>drivers = driversRepository.findAllByStatus(true);
        for (Driver d : drivers){
            distance = serviceforAll.getDistanceFromLatLonInKm(latitude , longitude ,d.getLatitude(),d.getLongitude());
            if(distance < 3){
                list.add(d);
            }
        }
        return list;
    }
}
