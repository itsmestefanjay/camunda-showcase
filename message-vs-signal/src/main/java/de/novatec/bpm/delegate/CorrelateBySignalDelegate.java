package de.novatec.bpm.delegate;

import de.novatec.bpm.constants.Signal;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorrelateBySignalDelegate implements JavaDelegate {

    private Logger logger = LoggerFactory.getLogger(CorrelateBySignalDelegate.class);

    @Autowired
    RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        String signal = Signal.CANCEL_EVERYTHING.getSignal();
        logger.info(String.format("Sending signal %s to all running instances", signal));
        runtimeService.createSignalEvent(signal).send();
    }
}
