package com.poc.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc.services.TrackerClient;

@RestController
@RequestMapping("/v1")
public class TrackerResource {
	
	@Autowired
	private TrackerClient trackerClient;
	
	@GetMapping
	public ResponseEntity<?> getResponse() {
		return new ResponseEntity(trackerClient.getProductStatus().getValue(), HttpStatus.OK);
	}

}
