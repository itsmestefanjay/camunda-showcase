package de.novatec.bpm.constants;

public enum Signal {

    CANCEL_SIGNAL("CancelSignal"),
    CANCEL_EVERYTHING("CancelEverything");

    private String name;

    Signal(String name) {
        this.name = name;
    }

    public String getSignal() {
        return this.name;
    }
}
