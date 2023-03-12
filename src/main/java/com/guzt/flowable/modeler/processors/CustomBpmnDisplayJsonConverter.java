package com.guzt.flowable.modeler.processors;

import org.flowable.ui.modeler.service.BpmnDisplayJsonConverter;

public class CustomBpmnDisplayJsonConverter extends BpmnDisplayJsonConverter {
    public CustomBpmnDisplayJsonConverter(){
        super();
        propertyMappers.put("UserTask", new CustomUserTaskInfoMapper());
    }
}
