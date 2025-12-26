package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService service;

    public WorkflowStepConfigController(
            WorkflowStepConfigService service) {
        this.service = service;
    }

    @PostMapping
    public WorkflowStepConfig createStep(
            @RequestBody WorkflowStepConfig step) {
        return service.saveStep(step);
    }

    @GetMapping("/template/{templateId}")
    public List<WorkflowStepConfig>
    getStepsForTemplate(
            @PathVariable Long templateId) {
        return service.getStepsByTemplate(templateId);
    }
}
