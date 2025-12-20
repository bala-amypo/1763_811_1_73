package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.service.WorkflowTemplateService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private WorkflowTemplateService service;

    public WorkflowTemplateController(WorkflowTemplateService service) {
        this.service = service;
    }

    // CREATE
    @PostMapping("/create")
    public WorkflowTemplate createTemplate(@RequestBody WorkflowTemplate template) {
        return service.saveTemplate(template);
    }

    // READ by ID
    @GetMapping("/get/{id}")
    public WorkflowTemplate getTemplate(@PathVariable Long id) {
        return service.getTemplateById(id);
    }

    // READ all
    @GetMapping("/all")
    public List<WorkflowTemplate> getAllTemplates() {
        return service.getAllTemplates();
    }

    // UPDATE
    @PutMapping("/update/{id}")
    public WorkflowTemplate updateTemplate(@PathVariable Long id,
                                           @RequestBody WorkflowTemplate template) {
        return service.updateTemplate(id, template);
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public String deleteTemplate(@PathVariable Long id) {
        service.deleteTemplate(id);
        return "Template deleted successfully";
    }
}
