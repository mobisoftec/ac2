package com.bf.exercise.ac.service;

import java.util.List;
import com.bf.exercise.ac.model.Aircraft;

public interface AircraftService {
		List<Aircraft> list();
		void add(Aircraft aircraft);
		void delete(Long id);
}
