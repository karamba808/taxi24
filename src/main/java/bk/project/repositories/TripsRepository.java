package bk.project.repositories;


import bk.project.domain.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface TripsRepository extends JpaRepository<Trips, Integer> {
    @Query(value = " from Trips t where t.status = 1")
    public List<Trips> findAllByStatus(int status);
}
