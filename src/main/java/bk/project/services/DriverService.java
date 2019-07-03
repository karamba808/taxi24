package bk.project.services;

import bk.project.domain.Driver;


import java.util.List;

public interface DriverService {
    public Driver createDriver(Driver driver);
    public List<Driver> allDrivers();
    public Driver findById(int id);
//    public List<Driver> availableDriver(double distance, double lat, double lng);
}
