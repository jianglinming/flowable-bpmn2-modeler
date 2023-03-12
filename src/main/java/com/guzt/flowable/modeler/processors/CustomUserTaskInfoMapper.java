package com.guzt.flowable.modeler.processors;

import org.apache.commons.lang3.StringUtils;
import org.flowable.bpmn.model.ExtensionAttribute;
import org.flowable.bpmn.model.FormProperty;
import org.flowable.bpmn.model.UserTask;
import org.flowable.editor.language.json.converter.util.CollectionUtils;
import org.flowable.ui.modeler.service.mapper.AbstractInfoMapper;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class CustomUserTaskInfoMapper extends AbstractInfoMapper {
    protected void mapProperties(Object element) {
        UserTask userTask = (UserTask) element;
        createPropertyNode("Assignee", userTask.getAssignee());
        createPropertyNode("Candidate users", userTask.getCandidateUsers());
        createPropertyNode("Candidate groups", userTask.getCandidateGroups());
        createPropertyNode("Due date", userTask.getDueDate());
        createPropertyNode("Form key", userTask.getFormKey());
        createPropertyNode("Priority", userTask.getPriority());
        if (CollectionUtils.isNotEmpty(userTask.getFormProperties())) {
            List<String> formPropertyValues = new ArrayList<>();
            for (FormProperty formProperty : userTask.getFormProperties()) {
                StringBuilder propertyBuilder = new StringBuilder();
                if (StringUtils.isNotEmpty(formProperty.getName())) {
                    propertyBuilder.append(formProperty.getName());
                } else {
                    propertyBuilder.append(formProperty.getId());
                }
                if (StringUtils.isNotEmpty(formProperty.getType())) {
                    propertyBuilder.append(" - ");
                    propertyBuilder.append(formProperty.getType());
                }
                if (formProperty.isRequired()) {
                    propertyBuilder.append(" (required)");
                } else {
                    propertyBuilder.append(" (not required)");
                }
                formPropertyValues.add(propertyBuilder.toString());
            }
            createPropertyNode("Form properties", formPropertyValues);
        }

        Map<String, List<ExtensionAttribute>> attributes = userTask.getAttributes();
        attributes.forEach((key, attr) -> {
            if("nodestate".equals(key) && attr!=null && attr.size()>0 ){
                String value = attr.get(0).getValue();
                if(!"".equals(value)){
                    createPropertyNode("节点状态",value);
                }
            }
            if("requirepermissions".equals(key)  && attr!=null && attr.size()>0 ){
                String value = attr.get(0).getValue();
                if(!"".equals(value)){
                    createPropertyNode("权限要求",value);
                }
            }
        });
        createListenerPropertyNodes("Task listeners", userTask.getTaskListeners());
        createListenerPropertyNodes("Execution listeners", userTask.getExecutionListeners());
    }

}
