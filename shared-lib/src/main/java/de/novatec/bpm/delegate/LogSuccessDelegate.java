package de.novatec.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogSuccessDelegate implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(LogSuccessDelegate.class);

    @Override
    public void execute(DelegateExecution execution) {
        logger.info(String.format("Task %s successful", execution.getProcessInstanceId()));

    }
}
