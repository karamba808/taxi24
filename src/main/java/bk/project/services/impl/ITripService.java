package bk.project.services.impl;

import bk.project.domain.Trips;
import bk.project.repositories.TripsRepository;

import bk.project.services.TripsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ITripService implements TripsService {
    @Autowired
    private TripsRepository tripsRepository;


    @Override
    public Trips createTrip(Trips trips) {
        return tripsRepository.save(trips);
    }

    @Override
    public List<Trips> completedTrips() {
        return tripsRepository.findAll();
    }

    @Override
    public Trips findOne(int id) {
        return tripsRepository.findById(id).get();
    }


}
