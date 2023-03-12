package com.guzt.flowable.modeler.processors;

import org.flowable.ui.modeler.service.BpmnDisplayJsonConverter;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;

public class BpmnDisplayJsonConverterBeanPostProcessor implements BeanPostProcessor {

    @Override
    public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
        if(bean instanceof BpmnDisplayJsonConverter){
            return new CustomBpmnDisplayJsonConverter();
        }
        return bean;
    }
}
