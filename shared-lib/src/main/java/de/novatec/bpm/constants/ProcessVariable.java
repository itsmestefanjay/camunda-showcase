package de.novatec.bpm.constants;

public enum ProcessVariable {

    KEY_TO_KILL("keyToKill"),
    ERROR_CODE("errorCode"),
    ERROR_MESSAGE("errorMessage"),
    CREDIT_CARD_LIST("creditCardList"),
    CARD("card"),
    CARD_STATUS("cardStatus");

    private String name;

    ProcessVariable(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
