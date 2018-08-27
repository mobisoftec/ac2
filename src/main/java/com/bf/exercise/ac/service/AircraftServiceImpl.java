package com.bf.exercise.ac.service;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bf.exercise.ac.model.Aircraft;
import com.bf.exercise.ac.model.AircraftRepository;

@Service("aircraftService")
public class AircraftServiceImpl implements AircraftService{

		@Autowired
		AircraftRepository aircrafts;
				
		public List<Aircraft> list() {
			return aircrafts.listAll();		
		}
		public void add(Aircraft aircraft) {
			aircrafts.insert(aircraft);
			// TODO Auto-generated method stub
		}
		public void delete(Long id) {
			aircrafts.delete(id);
			// TODO Auto-generated method stub
		}
}

