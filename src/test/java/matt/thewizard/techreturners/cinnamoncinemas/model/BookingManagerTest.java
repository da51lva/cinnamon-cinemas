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

        assertEquals(1, allocateSeats.size());

        Seat seat1 = allocateSeats.get(0);
        checkSeat(seat1, Row.A, SeatNumber.ONE);

    }

    @Test
    public void testEmptyTheatreDoubleAllocation() {

        List<Seat> allocateSeats = bookingManager.allocateSeats(2);

        assertEquals(2, allocateSeats.size());

        Seat seat1 = allocateSeats.get(0);
        checkSeat(seat1, Row.A, SeatNumber.ONE);
        Seat seat2 = allocateSeats.get(1);
        checkSeat(seat2, Row.A, SeatNumber.TWO);
    }

    private void checkSeat(Seat seat, Row row, SeatNumber seatNumber){
        assertEquals(row, seat.getRow());
        assertEquals(seatNumber, seat.getSeatNumber());
    }

}