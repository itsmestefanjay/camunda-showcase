package de.novatec.bpm;

import de.novatec.bpm.constants.ProcessVariable;
import org.camunda.bpm.engine.delegate.DelegateExecution;

public class VariableHandler {

    public static String get(DelegateExecution execution, ProcessVariable variable) {
        if(execution.getVariables().containsKey(variable.getName())) {
            return (String) execution.getVariable(variable.getName());
        } else {
            return null;
        }
    }

}
