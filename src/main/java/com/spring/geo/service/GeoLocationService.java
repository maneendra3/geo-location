package com.spring.geo.service;

import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import com.spring.geo.dto.IPDetailsDto;
import com.spring.geo.dto.IpContriesResponseDto;

/**
 * Service Layer which consumes API to fetch details based on IP
 * 
 * @author Maneendra
 *
 */
@Service
public class GeoLocationService {

	private static final Logger logger = LoggerFactory.getLogger(GeoLocationService.class);

	@Autowired
	private RestTemplate restTemplate;
	
	@Value("${ip.api.baseUrl}")
	private String apiUrl;

	public IpContriesResponseDto getNorthCountriesByIP(List<String> ipAddresses) {
		logger.info("GeoLocationService : getNorthCountriesByIP : Start");
		List<String> countriesList = ipAddresses.parallelStream().map(this::getIPDetails)
				.filter(res -> "success".equals(res.getStatus()) && res.getLat() > 0)
				.collect(Collectors.toCollection(() -> new TreeSet<>(Comparator.comparing(IPDetailsDto::getCountry))))
				.stream().collect(Collectors.mapping(IPDetailsDto::getCountry, Collectors.toList()));
		logger.info("GeoLocationService : getNorthCountriesByIP : northern hemisphere countries : ", countriesList);
		return new IpContriesResponseDto(countriesList);
	}

	private IPDetailsDto getIPDetails(String ip) {
		logger.info("GeoLocationService : consuming api to fetch IP details : " + ip);
		UriComponentsBuilder builder = UriComponentsBuilder.fromHttpUrl(apiUrl).pathSegment(ip);
		return restTemplate.getForEntity(builder.toUriString(), IPDetailsDto.class).getBody();
	}

}
