package com.event.management.event.controller;

import com.event.management.event.dto.request.EventDto;
import com.event.management.event.entity.Event;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.event.management.event.dto.response.CommonResponse;
import com.event.management.event.service.EventService;

import java.util.List;

@RestController
@RequestMapping("/event")
public class EventController {

	@Autowired
	private EventService eventService;

	@PostMapping("/createEvent")
	public ResponseEntity<CommonResponse> createEvent(@RequestBody EventDto eventDto){
		if(eventService.createEvent(eventDto))
			return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","Event has been successfully created"));
		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","unable to create event"));
	}

	@GetMapping("/fetchEventDetails")
	public Event fetchEventDetails(@RequestParam(name = "eventId") Long eventId){
		return eventService.fetchEventDetailsBasedOnId(eventId);
	}

	@GetMapping("/allEvents")
	public List<Event> fetchAllEvents(){
		return eventService.fetchAllEvents();
	}

	@PutMapping("/updateEvent")
	public ResponseEntity<CommonResponse> updateEvent(@RequestBody EventDto eventDto){
		if(eventService.updateEvent(eventDto))
			return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","Event has been successfully updated"));
		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","unable to update the event"));
	}

	@DeleteMapping("/deleteEvent")
	public ResponseEntity<CommonResponse> deleteEvent(@RequestParam(name = "eventId")Long eventId){
		if(eventService.deleteEvent(eventId))
			return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","Event has been successfully deleted"));
		return ResponseEntity.status(HttpStatus.OK).body(new CommonResponse("200","unable to delete the event"));

	}
}
