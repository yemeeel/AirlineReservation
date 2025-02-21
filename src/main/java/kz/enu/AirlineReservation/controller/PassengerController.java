package kz.enu.AirlineReservation.controller;

import kz.enu.AirlineReservation.entities.Passenger;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PassengerController {


    @GetMapping("/passengers")
    public List<Passenger> getPassengers() {

        return List.of(
                new Passenger(1L, "Yemel Alisher", 19),
                new Passenger(2L, "Yemel Talgat", 18)
        );
    }


    @GetMapping("/passenger/{id}")
    public Passenger getPassengerById(@PathVariable Long id) {

        return new Passenger(id, "Yemel Alisher", 19);
    }


    @PostMapping("/create_passenger")
    public Passenger createPassenger(@RequestParam Long id,
                                     @RequestParam String name,
                                     @RequestParam int age) {
        Passenger passenger = new Passenger(id, name, age);


        return passenger;
    }


    @PostMapping("/create_passenger_object")
    public Passenger createPassenger(@RequestBody Passenger passenger) {
        return passenger;
    }
}
