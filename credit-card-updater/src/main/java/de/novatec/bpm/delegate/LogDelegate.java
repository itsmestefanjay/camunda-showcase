package de.novatec.bpm.delegate;

import de.novatec.bpm.model.UserData;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class LogDelegate implements JavaDelegate {

    Logger logger = LoggerFactory.getLogger(LogDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        UserData card = (UserData) execution.getVariable("card");
        logger.info("Card {} evaluated. Expires in {} days", card.getNumber(), card.getDaysUntilExpiration());
        logger.info("Instance {} finished with status: {}", execution.getId(), execution.getVariable("cardStatus"));
    }
}
