package com.example.demo.controller;

import com.example.demo.model.WorkflowStepConfig;
import com.example.demo.service.WorkflowStepConfigService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/steps")
public class WorkflowStepConfigController {

    private final WorkflowStepConfigService service;

    public WorkflowStepConfigController(WorkflowStepConfigService service) {
        this.service = service;
    }

    @PostMapping
    public WorkflowStepConfig create(@RequestBody WorkflowStepConfig step) {
        return service.createStep(step);
    }

    @GetMapping("/template/{id}")
    public List<WorkflowStepConfig> list(@PathVariable Long id) {
        return service.getStepsForTemplate(id);
    }
}
