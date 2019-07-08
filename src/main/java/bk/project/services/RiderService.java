package bk.project.services;


import bk.project.domain.Driver;
import bk.project.domain.Rider;

import java.util.List;

public interface RiderService {
    public Rider createDriver(Rider rider);
    public List<Rider> allRivers();
    public Rider findById(int id);
    public List<Driver> searcharound(double latitude, double longitude);
}
