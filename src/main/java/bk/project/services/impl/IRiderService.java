package bk.project.services.impl;

import bk.project.domain.Rider;
import bk.project.repositories.RiderRepository;
import bk.project.services.RiderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IRiderService implements RiderService {
    @Autowired
    private RiderRepository riderRepository;


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
}
