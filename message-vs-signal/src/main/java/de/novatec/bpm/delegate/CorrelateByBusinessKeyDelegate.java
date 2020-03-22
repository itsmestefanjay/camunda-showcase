package de.novatec.bpm.delegate;

import de.novatec.bpm.VariableHandler;
import de.novatec.bpm.constants.Message;
import de.novatec.bpm.constants.ProcessVariable;
import org.camunda.bpm.engine.RuntimeService;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CorrelateByBusinessKeyDelegate implements JavaDelegate {

    private Logger logger = LoggerFactory.getLogger(CorrelateByBusinessKeyDelegate.class);

    @Autowired
    RuntimeService runtimeService;

    @Override
    public void execute(DelegateExecution execution) throws Exception {
        try {
            String keyToKill = VariableHandler.get(execution, ProcessVariable.KEY_TO_KILL);
            runtimeService.createMessageCorrelation(Message.CANCEL.getMessage()).processInstanceBusinessKey(keyToKill).correlateAll();
            logger.info(String.format("Instances killed with key %s", keyToKill));
        } catch(Exception e) {
            logger.error(String.format("Something went wrong: %s", e.getMessage()));
        }
    }
}
