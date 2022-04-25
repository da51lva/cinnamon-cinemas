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

        List<Seat> allocatedSeats = bookingManager.allocateSeats(1);

        assertEquals(1, allocatedSeats.size());

        Seat seat1 = allocatedSeats.get(0);
        checkSeat(seat1, Row.A, SeatNumber.ONE);

    }

    @Test
    public void testEmptyTheatreDoubleAllocation() {

        List<Seat> allocatedSeats = bookingManager.allocateSeats(2);

        assertEquals(2, allocatedSeats.size());

        Seat seat1 = allocatedSeats.get(0);
        checkSeat(seat1, Row.A, SeatNumber.ONE);
        Seat seat2 = allocatedSeats.get(1);
        checkSeat(seat2, Row.A, SeatNumber.TWO);
    }

    @Test
    public void testEmptyTheatreTripleAllocation() {

        List<Seat> allocatedSeats = bookingManager.allocateSeats(3);

        assertEquals(3, allocatedSeats.size());

        Seat seat1 = allocatedSeats.get(0);
        checkSeat(seat1, Row.A, SeatNumber.ONE);
        Seat seat2 = allocatedSeats.get(1);
        checkSeat(seat2, Row.A, SeatNumber.TWO);
        Seat seat3 = allocatedSeats.get(2);
        checkSeat(seat3, Row.A, SeatNumber.THREE);
    }

    private void checkSeat(Seat seat, Row row, SeatNumber seatNumber) {
        assertEquals(row, seat.getRow());
        assertEquals(seatNumber, seat.getSeatNumber());
    }

}