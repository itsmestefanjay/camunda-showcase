package de.novatec.bpm.delegate;

import de.novatec.bpm.constants.Message;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorrelateAllDelegate implements JavaDelegate {

    private Logger logger = LoggerFactory.getLogger(CorrelateAllDelegate.class);

    @Autowired
    RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        runtimeService.createMessageCorrelation(Message.CANCEL.getMessage()).correlateAll();
        logger.info(String.format("All running instances killed with message %s", Message.CANCEL.getMessage()));
    }
}
