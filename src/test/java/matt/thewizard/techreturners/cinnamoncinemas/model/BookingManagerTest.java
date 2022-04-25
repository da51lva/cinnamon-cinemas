package matt.thewizard.techreturners.cinnamoncinemas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookingManagerTest {

    BookingManager bookingManager;

    @BeforeEach
    public void setUp() {
        bookingManager = new BookingManager();
    }


    @Test
    public void testEmptyTheatreSingleAllocation() {

        List<Seat> allocateSeats = bookingManager.allocateSeats(1);
        Seat seat1 = allocateSeats.get(0);

        assertEquals(1, allocateSeats.size());
        assertEquals(Row.A, seat1.getRow());
        assertEquals(SeatNumber.ONE, seat1.getSeatNumber());

    }

}