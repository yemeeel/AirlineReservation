package kz.enu.AirlineReservation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.enu.AirlineReservation.entities.Passenger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassengerController {

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/passengers")
    public String getPassengers() {
        try {
            List<Passenger> passengers = List.of(new Passenger(1L, "Yemel Alisher", 19));
            return objectMapper.writeValueAsString(passengers);
        } catch (JsonProcessingException e) {
            return "Error serializing passengers: " + e.getMessage();
        }
    }


    @GetMapping("/passenger/{id}")
    public String getPassengerById(@PathVariable Long id) {
        try {
            Passenger passenger = new Passenger(id, "Yemel Alisher", 19);
            return objectMapper.writeValueAsString(passenger);
        } catch (JsonProcessingException e) {
            return "Error serializing passenger: " + e.getMessage();
        }
    }


    @PostMapping("/passengers")
    public List<Passenger> postPassengers() {
        return List.of(new Passenger(1L, "Yemel Alisher", 19));
    }


    @PostMapping("/passenger/{id}")
    public Passenger postPassengerById(@PathVariable Long id) {
        return new Passenger(id, "Yemel Alisher", 19);
    }


    @PostMapping("/create_passenger")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passenger;
    }
}
