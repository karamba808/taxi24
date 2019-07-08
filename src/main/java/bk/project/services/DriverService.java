package bk.project.services;

import bk.project.domain.Driver;

import java.util.List;

public interface DriverService {
    public Driver createDriver(Driver driver);
    public List<Driver> allDrivers();
    public List<Driver> availableDriver(boolean status);
    public Driver findById(int id);
    public List<Driver> availableDriver(double latitude, double longitude);
}
