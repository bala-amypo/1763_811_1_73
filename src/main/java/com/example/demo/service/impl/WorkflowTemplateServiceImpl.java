package com.example.demo.service.impl;

import com.example.demo.repository.WorkflowTemplateRepository;
import com.example.demo.entity.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class WorkflowTemplateServiceImpl implements WorkflowTemplateService {

    private final WorkflowTemplateRepository repo;

    public WorkflowTemplateServiceImpl(WorkflowTemplateRepository repo) {
        this.repo = repo;
    }

    public WorkflowTemplate createTemplate(WorkflowTemplate t) {
        return repo.save(t);
    }

    public WorkflowTemplate getTemplateById(Long id) {
        return repo.findById(id).orElseThrow();
    }

    public List<WorkflowTemplate> getAllTemplates() {
        return repo.findAll();
    }

    public WorkflowTemplate updateTemplate(Long id, WorkflowTemplate t) {
        t.setId(id);
        return repo.save(t);
    }

    public void activateTemplate(Long id, boolean active) {
        WorkflowTemplate t = getTemplateById(id);
        t.setActive(active);
        repo.save(t);
    }
}
