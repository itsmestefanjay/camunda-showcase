package de.novatec.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogCompensationDelegate implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(LogCompensationDelegate.class);

    @Override
    public void execute(DelegateExecution execution) {
        logger.info(String.format("Activity %s got compensated", execution.getActivityInstanceId()));
    }
}
