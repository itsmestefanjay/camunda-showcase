package de.novatec.bpm.constants;

public enum Error {

    SERVICE_FAILED("ServiceFailed", "E100", "Service failed");

    private String name;
    private String number;
    private String message;

    Error(String name, String number, String message) {
        this.name = name;
        this.number = number;
        this.message = message;
    }

    public String getName() {
        return name;
    }

    public String getNumber() {
        return number;
    }

    public String getMessage() {
        return message;
    }
}
