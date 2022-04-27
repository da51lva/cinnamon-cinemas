package matt.thewizard.techreturners.cinnamoncinemas.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BookingManagerTest {

    BookingManager bookingManager;

    @BeforeEach
    public void setUp() {
        bookingManager = new BookingManager(new MovieTheatre());
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

    @ParameterizedTest
    @CsvFileSource(resources = "/second-allocation-within-first-row.csv", numLinesToSkip = 1)
    public void testSecondAllocationOfSeatsWithinFirstRow(int firstAllocation, int secondAllocation, String expectedSeatNumberList) {
        bookingManager.allocateSeats(firstAllocation);
        List<Seat> allocatedSeats = bookingManager.allocateSeats(secondAllocation);

        assertEquals(secondAllocation, allocatedSeats.size());

        String[] expectedSeatNumbers = expectedSeatNumberList.split(" ");
        for (int i = 0; i < allocatedSeats.size(); i++) {
            checkSeat(allocatedSeats.get(i), "A", expectedSeatNumbers[i]);
        }
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/first-row-wrap.csv", numLinesToSkip = 1)
    public void testFirstRowWrap(String firstAllocationsList, int wrappingAllocation, String expectedSeatAllocationList) {
        makeMultipleAllocations(firstAllocationsList);
        checkAllocation(wrappingAllocation, expectedSeatAllocationList);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/test-multiple-allocations.csv", numLinesToSkip = 1)
    public void testMultipleAllocations(String firstAllocationList, int lastAllocation, String expectedSeatAllocationList) {
        makeMultipleAllocations(firstAllocationList);
        checkAllocation(lastAllocation, expectedSeatAllocationList);
    }

    @ParameterizedTest
    @CsvFileSource(resources = "/no-space-for-final-allocation.csv", numLinesToSkip = 1)
    public void testNoSpaceForFinalAllocation(String firstAllocationsList, int lastAllocation){
        makeMultipleAllocations(firstAllocationsList);
        List<Seat> allocatedSeats = bookingManager.allocateSeats(lastAllocation);
        assertTrue(allocatedSeats.isEmpty());
    }

    /**
     * Makes multiple allocations in the booking manager
     *
     * @param allocationsList - A List of the allocations to make as a space separated string e.g. "3 2 3 1"
     */
    private void makeMultipleAllocations(String allocationsList) {
        String[] firstAllocations = allocationsList.split(" ");
        for (String allocation : firstAllocations)
            bookingManager.allocateSeats(Integer.parseInt(allocation));
    }

    /**
     * Asserts that and allocation was successful
     *
     * @param allocation                 - the allocations to be made
     * @param expectedSeatAllocationList - the expected seat allocations as a space separated string e.g "A1 A2 A3"
     */
    private void checkAllocation(int allocation, String expectedSeatAllocationList) {
        List<Seat> allocatedSeats = bookingManager.allocateSeats(allocation);

        assertEquals(allocation, allocatedSeats.size());

        String[] expectedSeatAllocations = expectedSeatAllocationList.split(" ");
        for (int i = 0; i < allocatedSeats.size(); i++)
            checkSeat(
                    allocatedSeats.get(i),
                    expectedSeatAllocations[i].substring(0, 1), //expectedSeatAllocations have the format "A1"
                    expectedSeatAllocations[i].substring(1)
            );
    }

    @ParameterizedTest
    @CsvSource(textBlock = "-10,-1,0,4,10,100")
    public void checkIllegalAllocation(int allocation){
        assertThrows(IllegalArgumentException.class, () -> bookingManager.allocateSeats(allocation));
    }

    private void checkSeat(Seat seat, Row expectedRow, SeatNumber expectedSeatNumber) {
        assertEquals(expectedRow, seat.getRow());
        assertEquals(expectedSeatNumber, seat.getSeatNumber());
    }

    private void checkSeat(Seat seat, String expectedRow, String expectedSeatNumber) {
        assertEquals(expectedRow, seat.getRow().toString());
        assertEquals(expectedSeatNumber, seat.getSeatNumber().getStringRepresentation());
    }

}