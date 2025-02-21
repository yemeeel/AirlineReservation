package kz.enu.AirlineReservation.controller;

import kz.enu.AirlineReservation.entities.Flight;
import kz.enu.AirlineReservation.entities.Passenger;
import kz.enu.AirlineReservation.entities.Reservation;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReservationController {


    @GetMapping("/reservations")
    public List<Reservation> getReservations() {

        return List.of(
                new Reservation(1L, new Passenger(1L, "Yemel Alisher", 19), new Flight(1L, "AA101", "Astana", "Rome")),
                new Reservation(2L, new Passenger(2L, "Yemel Talgat", 18), new Flight(2L, "BB202", "Astana", "London"))
        );
    }


    @GetMapping("/reservation/{id}")
    public Reservation getReservationById(@PathVariable Long id) {

        Passenger passenger = new Passenger(id, "Yemel Alisher", 19);
        Flight flight = new Flight(1L, "AA101", "Astana", "Rome");
        return new Reservation(id, passenger, flight);
    }


    @PostMapping("/create_reservation")
    public Reservation createReservation(@RequestParam Long id,
                                         @RequestParam Long passengerId,
                                         @RequestParam String passengerName,
                                         @RequestParam int passengerAge,
                                         @RequestParam Long flightId,
                                         @RequestParam String flightNumber,
                                         @RequestParam String flightFrom,
                                         @RequestParam String flightTo) {
        Passenger passenger = new Passenger(passengerId, passengerName, passengerAge);
        Flight flight = new Flight(flightId, flightNumber, flightFrom, flightTo);
        Reservation reservation = new Reservation(id, passenger, flight);


        return reservation;
    }


    @PostMapping("/create_reservation_object")
    public Reservation createReservation(@RequestBody Reservation reservation) {

        return reservation;
    }
}
