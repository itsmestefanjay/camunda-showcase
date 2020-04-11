package de.novatec.bpm.delegate;

import de.novatec.bpm.CreditCardGenerator;
import de.novatec.bpm.model.UserData;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UserDataDelegate implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(UserDataDelegate.class);

    public static final int INVALID_COUNT = 200;
    public static final int VALID_COUNT = 1000;
    public static final int ALMOST_INVALID_COUNT = 100;

    @Autowired
    CreditCardGenerator generator;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        List<UserData> users = generator.getCreditCards(VALID_COUNT, INVALID_COUNT, ALMOST_INVALID_COUNT);
        logger.info("Received {} credit cards", users.size());
        execution.setVariable("creditCardList", users);
    }
}
