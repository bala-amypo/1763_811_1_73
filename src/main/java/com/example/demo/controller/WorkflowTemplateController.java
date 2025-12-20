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

    // POST - Create
    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate template) {
        return service.create(template);
    }

    // GET - Get by ID
    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // GET - Get all
    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return service.getAll();
    }

    // PUT - Full update
    @PutMapping("/{id}")
    public WorkflowTemplate update(@PathVariable Long id,
                                   @RequestBody WorkflowTemplate template) {
        return service.update(id, template);
    }

    // PATCH - Partial update
    @PatchMapping("/{id}")
    public WorkflowTemplate patch(@PathVariable Long id,
                                  @RequestBody WorkflowTemplate template) {
        return service.partialUpdate(id, template);
    }

    // DELETE
    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
