package org.launchcode.tournamentevents.controllers;

import org.launchcode.tournamentevents.data.EventRepository;
import org.launchcode.tournamentevents.models.Event;
import org.launchcode.tournamentevents.models.EventDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping(value = "events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public String displayEvents(
            @RequestParam(required = false) Integer categoryId,
            Model model
    ) {
        String sendToEventsIndexTemplateView = "events/index";

        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return sendToEventsIndexTemplateView;
    }

    @GetMapping(value = "create")
    public String displayCreateEventForm(Model model) {
        String eventsCreateTemplate =  "events/create";

        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        return eventsCreateTemplate;
    }

    @PostMapping(value = "create")
    public String processCreateEventForm(
            @ModelAttribute @Valid Event newEvent,
            Errors errors,
            Model model
    ) {
        String eventsCreateTemplate = "events/create";
        String redirect = "redirect:";

        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            model.addAttribute("errorMsg", "Bad data!");
            return eventsCreateTemplate;
        }
        eventRepository.save(newEvent);
        return redirect;
    }

    @GetMapping(value = "delete")
    public String displayDeleteEventForm(Model model) {
        String sendToEventsDeleteTemplateView = "events/delete";

        model.addAttribute(
                "title",
                "Delete Event"
        );

        model.addAttribute(
                "events",
                eventRepository.findAll()
        );

        return sendToEventsDeleteTemplateView;
    }

    @PostMapping(value = "delete")
    public String processDeleteEventForm(
            @RequestParam(required = false) int[] eventIds
    ) {
        String redirect = "redirect:";

        if(eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return redirect;
    }

    @GetMapping(value = "edit/{eventId}")
    public String displayEditEventForm(
            Model model,
            @PathVariable int eventId
            ) {
        String eventsEditTemplate =  "events/edit";
        Optional<Event> event = eventRepository.findById(eventId);
        Event eventToBeEdit = event.get();
        model.addAttribute("event", eventToBeEdit);
        String title = "Edit Event: " + eventToBeEdit.getName() + " (id=" + eventToBeEdit.getId() + ")";
        model.addAttribute("title", title);
        return eventsEditTemplate;
    }

    @PostMapping(value = "edit")
    public String processEditEventForm(
            int eventId,
            String name,
            EventDetails description,
            EventDetails location,
            EventDetails contactEmail,
            EventDetails date,
            EventDetails entryFee,
            EventDetails totalAudienceCapacity,
            EventDetails numberOfContestants
            ) {
        Optional<Event> event = eventRepository.findById(eventId);
        Event eventToBeEdit = event.get();
        eventToBeEdit.setName(name);
        eventToBeEdit.setEventDetails(description);
        eventToBeEdit.setEventDetails(location);
        eventToBeEdit.setEventDetails(contactEmail);
        eventToBeEdit.setEventDetails(date);
        eventToBeEdit.setEventDetails(entryFee);
        eventToBeEdit.setEventDetails(totalAudienceCapacity);
        eventToBeEdit.setEventDetails(numberOfContestants);
        eventRepository.save(eventToBeEdit);
        String redirect = "redirect:";
        return redirect;
    }
}
