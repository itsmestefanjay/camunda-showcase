package de.novatec.bpm.constants;

public enum Message {

    CANCEL("Cancel");

    private String name;

    Message(String name) {
        this.name = name;
    }

    public String getMessage() {
        return this.name;
    }
}
