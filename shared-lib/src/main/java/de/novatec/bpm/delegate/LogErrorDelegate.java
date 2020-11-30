package de.novatec.bpm.delegate;

import de.novatec.bpm.VariableHandler;
import de.novatec.bpm.constants.ProcessVariable;
import org.camunda.bpm.engine.delegate.DelegateExecution;
import org.camunda.bpm.engine.delegate.JavaDelegate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LogErrorDelegate implements JavaDelegate {

    private final Logger logger = LoggerFactory.getLogger(LogErrorDelegate.class);

    @Override
    public void execute(DelegateExecution execution) {
        String code = VariableHandler.get(execution, ProcessVariable.ERROR_CODE);
        logger.info(String.format("Task %s failed. Code: %s", execution.getProcessInstanceId(), code));

    }
}
