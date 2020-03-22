package de.novatec.bpm.delegate;

import de.novatec.bpm.constants.Error;
import org.camunda.bpm.engine.delegate.BpmnError;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ErrorHandlingDelegate implements JavaDelegate {

    private Logger logger = LoggerFactory.getLogger(ErrorHandlingDelegate.class);

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        try {
            SomeService.doSomething();
        } catch(IllegalAccessException e) {
            logger.info(String.format("Something is wrong, but i know this error: %s", e.getMessage()));
            throw new BpmnError(Error.SERVICE_FAILED.getNumber());
        }
    }

    static class SomeService {
        public static void doSomething() throws IllegalAccessException {
            throw new IllegalAccessException("There was an error executing this service");
        }
    }
}
