package com.event.management.event.service;

import com.event.management.event.dto.request.EventDto;
import com.event.management.event.entity.Event;

import java.util.List;

public interface EventService {

    boolean createEvent(EventDto eventDto);

    List<Event> fetchAllEvents();

    Event fetchEventDetailsBasedOnId(Long eventId);

    boolean updateEvent(EventDto eventDto);

    boolean deleteEvent(Long eventId);

}
