package kz.enu.AirlineReservation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.enu.AirlineReservation.entities.Flight;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/flights")
    public String getFlights() {
        try {
            List<Flight> flights = List.of(new Flight(1L, "AA101", "Astana", "Rome"));
            return objectMapper.writeValueAsString(flights);
        } catch (JsonProcessingException e) {
            return "Error serializing flights: " + e.getMessage();
        }
    }


    @GetMapping("/flight/{id}")
    public String getFlightById(@PathVariable Long id) {
        try {
            Flight flight = new Flight(id, "AA101", "Astana", "Rome");
            return objectMapper.writeValueAsString(flight);
        } catch (JsonProcessingException e) {
            return "Error serializing flight: " + e.getMessage();
        }
    }


    @PostMapping("/flights")
    public List<Flight> postFlights() {
        return List.of(new Flight(1L, "AA101", "Astana", "Rome"));
    }


    @PostMapping("/flight/{id}")
    public Flight postFlightById(@PathVariable Long id) {
        return new Flight(id, "AA101", "Astana", "Rome");
    }

    @PostMapping("/create_flight")
    public Flight createFlight(@RequestBody Flight flight) {
        return flight;
    }
}
