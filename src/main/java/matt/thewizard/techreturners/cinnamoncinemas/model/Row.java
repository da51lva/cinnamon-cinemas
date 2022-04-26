package matt.thewizard.techreturners.cinnamoncinemas.model;

public enum Row {
    A,
    B,
    C{
        @Override
        public Row next() { //The last row
            return this;
        }

    };

    public Row next() {
        return values()[this.ordinal() + 1];
    }
}
