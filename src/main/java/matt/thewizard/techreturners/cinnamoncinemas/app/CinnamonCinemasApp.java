package matt.thewizard.techreturners.cinnamoncinemas.app;

import matt.thewizard.techreturners.cinnamoncinemas.model.BookingManager;
import matt.thewizard.techreturners.cinnamoncinemas.model.MovieTheatre;
import matt.thewizard.techreturners.cinnamoncinemas.model.Seat;

import java.util.List;
import java.util.Random;

public class CinnamonCinemasApp {

    private static final int MIN_SEAT_ALLOCATION = 1;
    private static final int MAX_SEAT_ALLOCATION = 3;

    public static void main(String[] args) {

        BookingManager bookingManager = new BookingManager(new MovieTheatre());
        Random random = new Random();

        List<Seat> allocatedSeats;
        do { //continue randomly allocation number of seats 1 - 3 until no space
            int noOfSeats = random.nextInt(MIN_SEAT_ALLOCATION,MAX_SEAT_ALLOCATION+1);
            System.out.println("Attempting to the following number of seats: "+noOfSeats);

            allocatedSeats = bookingManager.allocateSeats(noOfSeats);
            System.out.println("Seats allocated: "+allocatedSeats);
        } while (!allocatedSeats.isEmpty());

        System.out.println("The Movie Theatre has no space for the final allocation. Programme Halting");
    }
}
