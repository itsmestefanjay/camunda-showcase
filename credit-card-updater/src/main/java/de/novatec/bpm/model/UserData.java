package de.novatec.bpm.model;

import java.io.Serializable;
import java.time.Duration;
import java.time.Instant;
import java.time.ZoneId;
import java.util.UUID;

public class UserData implements Serializable {

    private String userId;
    private String number;
    private String code;
    private Instant expiration;

    public UserData() {
        this.userId = UUID.randomUUID().toString();
    }

    public String getNumber() {
        return "**** **** **** " + number.substring(12);
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Instant getExpiration() {
        return expiration;
    }

    public void setExpiration(Instant expiration) {
        this.expiration = expiration;
    }

    public long getDaysUntilExpiration() {
        Duration duration = Duration.between(Instant.now().atZone(ZoneId.systemDefault()), expiration.atZone(ZoneId.systemDefault()));
        return duration.toDays();
    }

    public String getUserId() {
        return userId;
    }
}
