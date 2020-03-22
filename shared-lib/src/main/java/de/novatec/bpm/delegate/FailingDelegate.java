package de.novatec.bpm.delegate;

import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.ws.WebServiceException;

public class FailingDelegate implements JavaDelegate {

    private Logger logger = LoggerFactory.getLogger(FailingDelegate.class);

    @Override
    public void execute(DelegateExecution execution) {
        logger.error(String.format("Task %s failed", execution.getProcessInstanceId()));
        throw new WebServiceException("The webservice failed. Reason: Invalid message format");
    }
}
