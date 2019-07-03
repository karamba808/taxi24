package bk.project.repositories;

import bk.project.domain.Driver;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface DriversRepository extends JpaRepository<Driver, Integer> {

}
