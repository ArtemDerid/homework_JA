package ua.lviv.lgs.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ua.lviv.lgs.dao.UniversityRepository;
import ua.lviv.lgs.domain.University;
import ua.lviv.lgs.service.UniversityService;

@Service
public class UniversityServiceImpl implements UniversityService{
	
	@Autowired
	private UniversityRepository universityRepository;

	@Override
	public University save(University university) {
		return universityRepository.saveAndFlush(university);
	}

	@Override
	public University findById(Long id) {
		return universityRepository.getOne(id);
	}

	@Override
	public University update(University university) {
		return universityRepository.save(university);
	}

	@Override
	public void deleteById(Long id) {
		universityRepository.deleteById(id);
	}

	@Override
	public List<University> findByName(String name) {
		return universityRepository.findByName(name);
	}

	@Override
	public List<University> findByAddress(String address) {
		return universityRepository.findByAddress(address);
	}

	@Override
	public List<University> findAll() {
		return universityRepository.findAll();
	}

}
