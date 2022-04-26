package matt.thewizard.techreturners.cinnamoncinemas.model;

public class MovieTheatre {

    private static final Row FIRST_ROW = Row.A;
    private static final SeatNumber FIRST_SEAT_NUMBER = SeatNumber.ONE;
    private static final SeatNumber LAST_SEAT_NUMBER = SeatNumber.FIVE;

    private Seat currentSeat = null;

    /**
     * @return the next free seat in the MovieTheatre
     */
    public Seat nextSeat() {
        if (currentSeat == null)
            currentSeat = new Seat(FIRST_ROW, FIRST_SEAT_NUMBER);
        else
            currentSeat = incrementSeat(currentSeat);

        return currentSeat;
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
