package com.example.demo.service.impl;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.repository.WorkflowStepConfigRepository;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkflowStepConfigServiceImpl implements WorkflowStepConfigService {

    private final WorkflowStepConfigRepository repo;

    public WorkflowStepConfigServiceImpl(WorkflowStepConfigRepository repo) {
        this.repo = repo;
    }

    public WorkflowStepConfig createStep(WorkflowStepConfig step) {
        return repo.save(step);
    }

    public List<WorkflowStepConfig> getStepsForTemplate(Long templateId) {
        return repo.findByTemplateIdOrderByLevelNumberAsc(templateId);
    }
}
