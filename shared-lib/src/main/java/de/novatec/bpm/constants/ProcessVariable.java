package de.novatec.bpm.constants;

public enum ProcessVariable {

    KEY_TO_KILL("keyToKill"),
    ERROR_CODE("errorCode"),
    ERROR_MESSAGE("errorMessage");

    private String name;

    ProcessVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
