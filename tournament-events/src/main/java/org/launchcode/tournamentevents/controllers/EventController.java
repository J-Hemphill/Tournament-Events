package org.launchcode.tournamentevents.controllers;

import org.launchcode.tournamentevents.data.EventRepository;
import org.launchcode.tournamentevents.models.Event;
import org.launchcode.tournamentevents.models.TypeOfTournament;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Optional;

@Controller
@RequestMapping("events")
public class EventController {

    @Autowired
    private EventRepository eventRepository;

    @GetMapping
    public String displayEvents(Model model) {
        model.addAttribute("title", "All Events");
        model.addAttribute("events", eventRepository.findAll());
        return "events/index";
    }

    @GetMapping(value = "create")
    public String displayCreateEventForm(Model model) {
        model.addAttribute("title", "Create Event");
        model.addAttribute(new Event());
        model.addAttribute("types", TypeOfTournament.values());
        return "events/create";
    }

    @PostMapping(value = "create")
    public String processCreateEventForm(
            @ModelAttribute @Valid Event newEvent,
            Errors errors,
            Model model
    ){
        if(errors.hasErrors()) {
            model.addAttribute("title", "Create Event");
            return "events/create";
        }
        eventRepository.save(newEvent);
        return "redirect:";
    }

    @GetMapping(value = "delete")
    public String displayDeleteEventForm(Model model) {

        model.addAttribute(
                "title",
                "Delete Events"
        );

        model.addAttribute(
                "events",
                eventRepository.findAll()
        );
        return "events/delete";
    }

    @PostMapping(value = "delete")
    public String processDeleteEventForm(@RequestParam(required = false) int[] eventIds) {
        if(eventIds != null) {
            for (int id : eventIds) {
                eventRepository.deleteById(id);
            }
        }
        return "redirect:";
    }

    @GetMapping(value = "edit")
    public String displayEditEventForm(Model model) {

        model.addAttribute(
                "title",
                "Edit Events"
        );

        model.addAttribute(
                "events",
                eventRepository.findAll()
        );
        return "events/edit";
    }

    @PostMapping(value = "edit")
    public String processEditEventForm(@RequestParam(required = false) int[] eventIds) {
        if(eventIds != null) {
            for (int id : eventIds) {
//                eventRepository.existsById(eventIds);
            }
        }
        return "redirect:";
    }

    @GetMapping(value = "detail")
    public String displayEventDetails (
            @RequestParam Integer eventId,
            Model model
    ) {
        Optional<Event> result = eventRepository.findById(eventId);

        if (result.isEmpty()) {
            model.addAttribute("title", "Invalid Event ID: " + eventId);
        } else {
            Event event = result.get();
            model.addAttribute("title", event.getName() + " Details");
            model.addAttribute("event", event);
        }
        return "events/detail";
    }
}
