package ua.lviv.lgs.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import ua.lviv.lgs.domain.University;

public interface UniversityRepository extends CrudRepository<University, Long>, JpaRepository<University, Long>{
	
	List<University> findByName(String name);
	List<University> findByAddress(String address);
}
