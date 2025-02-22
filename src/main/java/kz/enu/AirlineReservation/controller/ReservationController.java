package kz.enu.AirlineReservation.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import kz.enu.AirlineReservation.entities.Flight;
import kz.enu.AirlineReservation.entities.Passenger;
import kz.enu.AirlineReservation.entities.Reservation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {

    @Autowired
    private ObjectMapper objectMapper;


    @GetMapping("/reservations")
    public String getReservations() {
        try {
            List<Reservation> reservations = List.of(new Reservation(1L, new Passenger(1L, "Yemel Alisher", 19), new Flight(1L, "AA101", "Astana", "Rome")));
            return objectMapper.writeValueAsString(reservations);
        } catch (JsonProcessingException e) {
            return "Error serializing reservations: " + e.getMessage();
        }
    }


    @GetMapping("/reservation/{id}")
    public String getReservationById(@PathVariable Long id) {
        try {
            Reservation reservation = new Reservation(id, new Passenger(1L, "Yemel Alisher", 19), new Flight(1L, "AA101", "Astana", "Rome"));
            return objectMapper.writeValueAsString(reservation);
        } catch (JsonProcessingException e) {
            return "Error serializing reservation: " + e.getMessage();
        }
    }


    @PostMapping("/reservations")
    public List<Reservation> postReservations() {
        return List.of(new Reservation(1L, new Passenger(1L, "Yemel Alisher", 19), new Flight(1L, "AA101", "Astana", "Rome")));
    }


    @PostMapping("/reservation/{id}")
    public Reservation postReservationById(@PathVariable Long id) {
        return new Reservation(id, new Passenger(1L, "Yemel Alisher", 19), new Flight(1L, "AA101", "Astana", "Rome"));
    }

    @PostMapping("/create_reservation")
    public Reservation createReservation(@RequestBody Reservation reservation) {
        return reservation;
    }
}
