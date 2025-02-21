package kz.enu.AirlineReservation.controller;

import kz.enu.AirlineReservation.entities.Flight;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class FlightController {


    @GetMapping("/flights")
    public List<Flight> getFlights() {
        return List.of(
                new Flight(1L, "AA101", "Astana", "Rome"),
                new Flight(2L, "BB202", "Astana", "London")
        );
    }


    @GetMapping("/flight/{id}")
    public Flight getFlightById(@PathVariable Long id) {

        return new Flight(id, "AA101", "Astana", "Rome");
    }


    @PostMapping("/create_flight")
    public Flight createFlight(@RequestParam Long id,
                               @RequestParam String flightCode,
                               @RequestParam String departureCity,
                               @RequestParam String arrivalCity) {
        Flight flight = new Flight(id, flightCode, departureCity, arrivalCity);

        return flight;
    }


    @PostMapping("/create_flight_object")
    public Flight createFlight(@RequestBody Flight flight) {

        return flight;
    }
}
