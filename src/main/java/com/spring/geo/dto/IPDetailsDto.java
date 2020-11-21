package com.spring.geo.dto;

public class IPDetailsDto {
	
	private String status;
	private Float lat;
	private Float lon;
	private String message;
	private String country;
	private String regionName;
	private String city;
	
	public IPDetailsDto() {
		super();
	}

	public IPDetailsDto(String status, Float lat, Float lon, String message, String country, String regionName,
			String city) {
		super();
		this.status = status;
		this.lat = lat;
		this.lon = lon;
		this.message = message;
		this.country = country;
		this.regionName = regionName;
		this.city = city;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Float getLat() {
		return lat;
	}

	public void setLat(Float lat) {
		this.lat = lat;
	}

	public Float getLon() {
		return lon;
	}

	public void setLon(Float lon) {
		this.lon = lon;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getRegionName() {
		return regionName;
	}

	public void setRegionName(String regionName) {
		this.regionName = regionName;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	@Override
	public String toString() {
		return "IPDetails [status=" + status + ", lat=" + lat + ", lon=" + lon + ", message=" + message + ", country="
				+ country + ", regionName=" + regionName + ", city=" + city + "]";
	}
	
}
