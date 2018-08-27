package com.bf.exercise.ac.controller;

import java.util.List;

//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.bf.exercise.ac.model.Aircraft;
import com.bf.exercise.ac.service.AircraftService;

@RestController
@RequestMapping("/aircraft")
public class RestAPIController {

		@Autowired
		AircraftService aircraftService;
		
		// List Queue

		@GetMapping(value="queue")
		public ResponseEntity<List<Aircraft>> listQueue() {
			List<Aircraft> aircrafts = aircraftService.list();
			if (aircrafts.isEmpty()) {
				return new ResponseEntity<List<Aircraft>>(HttpStatus.NOT_FOUND);
			}
			return new ResponseEntity<List<Aircraft>>(aircrafts, HttpStatus.OK);
		}

		//Enqueue

		@PostMapping("enqueue")
		public ResponseEntity<Void> addAircraft(@RequestBody Aircraft aircraft, UriComponentsBuilder ucBuilder) {
			aircraftService.add(aircraft);
			HttpHeaders headers = new HttpHeaders();
			headers.setLocation(ucBuilder.path("/enqueue/{id}").buildAndExpand(aircraft.getId()).toUri());
			return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
		}

		//Dequeue by aircraft id
		@DeleteMapping("dequeue/{id}")
		public ResponseEntity<Void> deleteAircraft(@PathVariable("id") Long id) {
			aircraftService.delete(id);
			return new ResponseEntity<Void>(HttpStatus.NO_CONTENT);
		}	


}
