package matt.thewizard.techreturners.cinnamoncinemas.model;

import java.util.ArrayList;
import java.util.List;

public class BookingManager {

    MovieTheatre movieTheatre;

    public BookingManager(MovieTheatre movieTheatre) {
        this.movieTheatre = movieTheatre;
    }

    /**
     * Will allocate seats in the movie seat for a given number of seats.
     *
     * @param numberOfSeats - the number of seats to allocate
     * @return a List of the Seat allocations made. The size of the returned list should equal the given int.
     */
    public List<Seat> allocateSeats(int numberOfSeats) {

        List<Seat> allocatedSeats = new ArrayList<>();

        for(int i = 0; i < numberOfSeats; i++){
            Seat seat = movieTheatre.nextSeat();
            allocatedSeats.add(seat);
        }

        return allocatedSeats;
    }

}
