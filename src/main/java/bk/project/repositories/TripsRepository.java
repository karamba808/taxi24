package bk.project.repositories;


import bk.project.domain.Trips;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;



@Repository
public interface TripsRepository extends JpaRepository<Trips, Integer> {
}
