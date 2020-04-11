package de.novatec.bpm;

import de.novatec.bpm.model.UserData;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

@Component
public class CreditCardGenerator {


    public static final int SEC_CODE_LENGTH = 3;
    public static final int CC_NO_LENGTH = 16;

    public List<UserData> getCreditCards(int valid, int invalid, int almost) {
        List<UserData> result = new ArrayList<>();
        result.addAll(getValidCards(valid));
        result.addAll(getInvalidCards(invalid));
        result.addAll(getAlmostInvalidCards(almost));
        result.sort((a, b) -> a.getUserId().compareToIgnoreCase(b.getUserId()));
        return result;
    }

    private List<UserData> getInvalidCards(int count) {
        List<UserData> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            UserData data = new UserData();
            data.setCode(generateNumber(SEC_CODE_LENGTH));
            data.setNumber(generateNumber(16));
            data.setExpiration(Instant.now().atZone(ZoneId.systemDefault()).minusYears(1).toInstant());
            result.add(data);
        }
        return result;
    }

    private List<UserData> getValidCards(int count) {
        List<UserData> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            UserData data = new UserData();
            data.setCode(generateNumber(SEC_CODE_LENGTH));
            data.setNumber(generateNumber(16));
            data.setExpiration(Instant.now().atZone(ZoneId.systemDefault()).plusYears(3).toInstant());
            result.add(data);
        }
        return result;
    }

    private List<UserData> getAlmostInvalidCards(int count) {
        List<UserData> result = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            UserData data = new UserData();
            data.setCode(generateNumber(SEC_CODE_LENGTH));
            data.setNumber(generateNumber(CC_NO_LENGTH));
            data.setExpiration(Instant.now().atZone(ZoneId.systemDefault()).plusDays(42).toInstant());
            result.add(data);
        }
        return result;
    }

    private String generateNumber(int length) {
        return RandomStringUtils.random(length, false, true);
    }

}
