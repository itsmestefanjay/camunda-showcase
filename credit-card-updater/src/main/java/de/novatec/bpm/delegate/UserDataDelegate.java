package de.novatec.bpm.delegate;

import de.novatec.bpm.model.UserData;
import org.apache.commons.lang3.RandomStringUtils;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.camunda.bpm.engine.variable.value.TypedValue;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.time.Instant;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;

public class UserDataDelegate implements JavaDelegate {

    public static final int INVALID_COUNT = 1800;
    public static final int VALID_COUNT = 10000;
    public static final int ALMOST_INVALID_COUNT = 1900;
    public static final int SEC_CODE_LENGTH = 3;
    public static final int CC_NO_LENGTH = 16;

    Logger logger = LoggerFactory.getLogger(UserDataDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<UserData> users = getUsers();
        logger.info("Generated {} credit cards", users.size());
        execution.setVariable("creditCardList", users);
    }

    public List<UserData> getUsers() {
        List<UserData> result = new ArrayList<>();
        result.addAll(getValidCards());
        result.addAll(getAlmostInvalidCards());
        result.addAll(getInvalidCards());
        return result;
    }

    public List<UserData> getInvalidCards() {
        List<UserData> result = new ArrayList<>();
        for (int i = 0; i < INVALID_COUNT; i++) {
            UserData data = new UserData();
            data.setCode(generate(SEC_CODE_LENGTH));
            data.setNumber(generate(16));
            data.setExpiration(Instant.now().atZone(ZoneId.systemDefault()).minusYears(1).toInstant());
            result.add(data);
        }
        return result;
    }

    public List<UserData> getValidCards() {
        List<UserData> result = new ArrayList<>();
        for (int i = 0; i < VALID_COUNT; i++) {
            UserData data = new UserData();
            data.setCode(generate(SEC_CODE_LENGTH));
            data.setNumber(generate(16));
            data.setExpiration(Instant.now().atZone(ZoneId.systemDefault()).plusYears(3).toInstant());
            result.add(data);
        }
        return result;
    }

    public List<UserData> getAlmostInvalidCards() {
        List<UserData> result = new ArrayList<>();
        for (int i = 0; i < ALMOST_INVALID_COUNT; i++) {
            UserData data = new UserData();
            data.setCode(generate(SEC_CODE_LENGTH));
            data.setNumber(generate(CC_NO_LENGTH));
            data.setExpiration(Instant.now().atZone(ZoneId.systemDefault()).plusDays(42).toInstant());
            result.add(data);
        }
        return result;
    }

    public String generate(int length) {
        return RandomStringUtils.random(length, false, true);
    }
}
