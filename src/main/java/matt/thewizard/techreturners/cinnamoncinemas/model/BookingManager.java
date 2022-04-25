package matt.thewizard.techreturners.cinnamoncinemas.model;

import java.util.List;

public class BookingManager {

    /**
     * Will allocate seats in the movie seat for a given number of seats.
     *
     * @param numberOfSeats - the number of seats to allocate
     * @return a List of the Seat allocations made. The size of the returned list should equal the given int.
     */
    public List<Seat> allocateSeats(int numberOfSeats) {
        return List.of(new Seat(Row.A, SeatNumber.ONE));
    }

}
