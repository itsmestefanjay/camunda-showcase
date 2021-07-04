package de.novatec.bpm.config;

import org.camunda.bpm.engine.impl.cfg.ProcessEngineConfigurationImpl;
import org.camunda.bpm.spring.boot.starter.configuration.impl.AbstractCamundaConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Order(1)
public class ApplicationConfig extends AbstractCamundaConfiguration {

  Logger logger = LoggerFactory.getLogger(ApplicationConfig.class);

  @Override
  public void preInit(ProcessEngineConfigurationImpl processEngineConfiguration) {
    processEngineConfiguration.setInitializeTelemetry(false);
    processEngineConfiguration.setTelemetryReporterActivate(false);
    logger.info("Telemetry disabled!");
  }
}
