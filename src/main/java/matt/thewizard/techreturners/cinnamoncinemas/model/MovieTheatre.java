package matt.thewizard.techreturners.cinnamoncinemas.model;

public class MovieTheatre {

    private static final Row FIRST_ROW = Row.A;
    private static final SeatNumber FIRST_SEAT_NUMBER = SeatNumber.ONE;
    private static final SeatNumber LAST_SEAT_NUMBER = SeatNumber.FIVE;

    private Seat currentSeat = null;

    public Seat nextSeat() {
        if (currentSeat == null)
            currentSeat = new Seat(FIRST_ROW, FIRST_SEAT_NUMBER);
        else
            currentSeat = incrementSeat(currentSeat);

        return currentSeat;
    }

    private Seat incrementSeat(Seat lastSeat) {
        Row row = lastSeat.getRow();
        if (lastSeat.seatNumber == LAST_SEAT_NUMBER)
            row = row.next();

        return new Seat(row, lastSeat.seatNumber.next());
    }


}
