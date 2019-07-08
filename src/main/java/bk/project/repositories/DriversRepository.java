package bk.project.repositories;

import bk.project.domain.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface DriversRepository extends JpaRepository<Driver, Integer> {
    public List<Driver>findAllByStatus(boolean status);
}
