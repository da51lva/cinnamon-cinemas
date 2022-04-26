package matt.thewizard.techreturners.cinnamoncinemas.model;

public enum SeatNumber {

    ONE("1"),
    TWO("2"),
    THREE("3"),
    FOUR("4"),
    FIVE("5");

    private final String stringRepresentation;

    SeatNumber(String stringRepresentation) {
        this.stringRepresentation = stringRepresentation;
    }

    public String getStringRepresentation() {
        return stringRepresentation;
    }

    public SeatNumber next() {
        return values()[(this.ordinal() + 1) % 5]; //wraps from 5 to 1
    }
}
