package bk.project.services;

import bk.project.domain.Trips;

import java.util.List;

public interface TripsService {
    public Trips createTrip(Trips trips);
    public List<Trips> completedTrips();
    public Trips findOne(int id);
    public Trips completeTrip(Trips trips);
}
