package com.spring.geo.dto;

import java.util.List;

public class IpContriesResponseDto {
	
	private List<String> northCountries;

	public IpContriesResponseDto() {
		super();
	}

	public IpContriesResponseDto(List<String> northCountries) {
		super();
		this.northCountries = northCountries;
	}

	public List<String> getNorthCountries() {
		return northCountries;
	}

	public void setNorthCountries(List<String> northCountries) {
		this.northCountries = northCountries;
	}

}
