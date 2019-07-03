package bk.project.services.impl;


import bk.project.domain.Driver;
import bk.project.repositories.DriversRepository;
import bk.project.services.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IDriverService implements DriverService {
    @Autowired
    private DriversRepository driversRepository;


    @Override
    public Driver createDriver(Driver driver) {
        return driversRepository.save(driver);
    }

    @Override
    public List<Driver> allDrivers() {
        return driversRepository.findAll();
    }

    @Override
    public Driver findById(int id) {
        return driversRepository.findById(id).get();
    }
}
