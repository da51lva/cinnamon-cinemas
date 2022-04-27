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
     * @return - a List of the Seat allocations made. Is Empty if there is no space for the full allocation in the Movie Theatre
     * @throws - IllegalArgumentException if given number of seats not between 1-3 inclusive.
     */
    public List<Seat> allocateSeats(int numberOfSeats) {

        if (numberOfSeats < 1 || numberOfSeats > 3)
            throw new IllegalArgumentException("Only 1-3 seats can be allocated at a time");

        List<Seat> allocatedSeats = new ArrayList<>();

        if (movieTheatre.hasSpace(numberOfSeats)) {
            for (int i = 0; i < numberOfSeats; i++) {
                Seat seat = movieTheatre.nextSeat();
                allocatedSeats.add(seat);
            }
        }

        return allocatedSeats;
    }

}
