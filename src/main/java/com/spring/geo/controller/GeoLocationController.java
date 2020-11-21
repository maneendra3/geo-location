package com.spring.geo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.spring.geo.service.GeoLocationService;

/**
 * 
 * Controller class for GeoLocation API Management
 * 
 * @author Maneendra
 *
 */
@RestController
@RequestMapping("/api")
public class GeoLocationController {

	private static final Logger logger = LoggerFactory.getLogger(GeoLocationController.class);

	@Autowired
	private GeoLocationService geoLocationService;

	@GetMapping("/northCountriesByIP")
	public ResponseEntity<?> getNorthCountriesByIps(
			@RequestParam(name = "ip", required = false) List<String> ipAddresses) {
		logger.info("input ip address are : {}", ipAddresses);
		if (CollectionUtils.isEmpty(ipAddresses) || ipAddresses.size() > 5) {
			return ResponseEntity.badRequest().body("Atleast 1 and not greater than 5 IP Addresses should be given");
		}
		return ResponseEntity.ok(geoLocationService.getNorthCountriesByIP(ipAddresses));
	}

}
