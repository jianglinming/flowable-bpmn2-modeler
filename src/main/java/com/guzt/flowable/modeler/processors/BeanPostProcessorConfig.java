package com.guzt.flowable.modeler.processors;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanPostProcessorConfig {
    @Bean
    public BpmnDisplayJsonConverterBeanPostProcessor myBeanPostProcessor() {
        return new BpmnDisplayJsonConverterBeanPostProcessor();
    }
}
