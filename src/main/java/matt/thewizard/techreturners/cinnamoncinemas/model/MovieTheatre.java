package matt.thewizard.techreturners.cinnamoncinemas.model;

public class MovieTheatre {

    private static final int CAPACITY = Row.values().length * SeatNumber.values().length;
    private static final Row FIRST_ROW = Row.A;
    private static final SeatNumber FIRST_SEAT_NUMBER = SeatNumber.ONE;
    private static final SeatNumber LAST_SEAT_NUMBER = SeatNumber.FIVE;

    private int allocatedSeats = 0;
    private Seat currentSeat = null;

    /**
     * @return the next free seat in the MovieTheatre
     */
    public Seat nextSeat() {
        if (allocatedSeats == CAPACITY)
            throw new IllegalArgumentException("The Movie Theatre has no seats left");
        else if (currentSeat == null)
            currentSeat = new Seat(FIRST_ROW, FIRST_SEAT_NUMBER);
        else
            currentSeat = incrementSeat(currentSeat);

        allocatedSeats++;
        return currentSeat;
    }

    /**
     * Returns whether the theatre has space to allocate the given number of seats
     */
    public boolean hasSpace(int noOfSeats) {
        return CAPACITY - allocatedSeats >= noOfSeats;
    }


    /**
     * Given a Seat, returns the next seat
     */
    private Seat incrementSeat(Seat seat) {
        Row row = seat.getRow();
        if (seat.seatNumber == LAST_SEAT_NUMBER)
            row = row.next();

        return new Seat(row, seat.seatNumber.next());
    }

}
