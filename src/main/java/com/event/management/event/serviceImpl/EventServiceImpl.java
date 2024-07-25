package com.event.management.event.serviceImpl;

import com.event.management.event.dao.EventDao;
import com.event.management.event.dto.request.EventDto;
import com.event.management.event.entity.Event;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.event.management.event.service.EventService;

import java.util.List;
import java.util.Optional;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventDao eventDao;

    @Override
    public boolean createEvent(EventDto eventDto) {
        Event event=initializeEventEntity(eventDto);
        Event saved=eventDao.save(event);
        if(saved!=null)
            return true;
        return false;
    }

    private Event initializeEventEntity(EventDto eventDto){
        Event event=new Event();
        BeanUtils.copyProperties(eventDto,event);
        return event;
    }

    @Override
    public List<Event> fetchAllEvents() {
        List<Event> eventList=eventDao.findAll();
        return eventList;
    }

    @Override
    public Event fetchEventDetailsBasedOnId(Long eventId) {
        Optional<Event> eventDetails= eventDao.findById(eventId);
        if(eventDetails.isPresent())
            return eventDetails.get();
        return null;
    }

    @Override
    public boolean updateEvent(EventDto eventDto) {
        if(eventDto!= null){
            Event event=fetchEventDetailsBasedOnId(eventDto.getEventId());
            BeanUtils.copyProperties(eventDto, event);
            eventDao.save(event);
            return true;
        }
        return false;
    }

    @Override
    public boolean deleteEvent(Long eventId) {
        Event event=fetchEventDetailsBasedOnId(eventId);
        if(event!=null){
            eventDao.delete(event);
            return true;
        }
        return false;
    }
}
