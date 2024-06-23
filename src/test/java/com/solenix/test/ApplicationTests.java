package com.solenix.test;

import com.solenix.Application;
import com.solenix.controller.SatelliteEventController;
import com.solenix.dto.EventDTO;
import com.solenix.dto.SatelliteDTO;
import com.solenix.dto.SatelliteData;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.test.web.server.LocalServerPort;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;

import java.util.Calendar;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest(classes = Application.class, webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ApplicationTests {

	private static final Logger logger = LoggerFactory.getLogger(ApplicationTests.class);

	//TestRestTemplate bean will be registered automatically after @SpringBootTest is started
	@Autowired
	private TestRestTemplate restTemplate;

	@LocalServerPort
	private int port;

	@Autowired
	private ObjectMapper objectMapper;

	private String getRootUrl() {
		return "http://localhost:" + port +"/api";
	}

	@Test
	public void contextLoads() {}

	@Test
	public void testCreateEvent() {
		EventDTO eventDTO = new EventDTO();
		eventDTO.setDate(Calendar.getInstance().getTime());
		eventDTO.setDescription("This is a new event.");
		eventDTO.setPriority("low");
		eventDTO.setSatelliteName("SENTINEL-9");
		logger.info("EventDTO" + eventDTO);
		ResponseEntity<Object> postResponse = restTemplate.postForEntity(getRootUrl() + "/events/create", eventDTO,
				Object.class);

		assertEquals(postResponse.getStatusCode(), HttpStatus.BAD_REQUEST);
	}

	@Test
	public void testGetAllEvents() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<List<EventDTO>> response = restTemplate.exchange(
				getRootUrl() + "/events/list",
				HttpMethod.GET,
				entity,
				new ParameterizedTypeReference<List<EventDTO>>() {}
		);

		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testGetEventBySatellite() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<>(null, headers);
		ResponseEntity<List<EventDTO>> response = restTemplate.exchange(
				getRootUrl() + "/events/satellite/" + "STARLINK-31654",
				HttpMethod.GET,
				entity,
				new ParameterizedTypeReference<List<EventDTO>>() {}
		);

		assertEquals(response.getStatusCode(), HttpStatus.OK);
	}

	@Test
	public void testGetAllSatellite() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<List<SatelliteDTO>> response = restTemplate.exchange(
				getRootUrl() + "/satellites/list",
				HttpMethod.GET,
				entity,
				new ParameterizedTypeReference<List<SatelliteDTO>>() {}
		);

		assertNotNull(response);
	}

	@Test
	public void testTleBySatellite() {
		HttpHeaders headers = new HttpHeaders();
		HttpEntity<String> entity = new HttpEntity<String>(null, headers);
		ResponseEntity<SatelliteData> response = restTemplate.exchange(
				getRootUrl() + "/tle/satellite/" + "STARLINK-31654",
				HttpMethod.GET,
				entity, SatelliteData.class
		);

		assertEquals(response.getStatusCode(), HttpStatus.NOT_FOUND);
	}

}
