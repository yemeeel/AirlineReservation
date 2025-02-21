package kz.enu.AirlineReservation.entities;

public class Reservation {
    private Long id;
    private Passenger passenger;
    private Flight flight;

    public Reservation(Long id, Passenger passenger, Flight flight) {
        this.id = id;
        this.passenger = passenger;
        this.flight = flight;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    @Override
    public String toString() {
        return "Reservation{" +
                "id=" + id +
                ", passenger=" + passenger +
                ", flight=" + flight +
                '}';
    }
}
