package com.example.demo.controller;

import com.example.demo.entity.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate t) {
        return service.createTemplate(t);
    }

    @GetMapping("/{id}")
    public WorkflowTemplate get(@PathVariable Long id) {
        return service.getTemplateById(id);
    }

    @GetMapping
    public List<WorkflowTemplate> all() {
        return service.getAllTemplates();
    }
}
