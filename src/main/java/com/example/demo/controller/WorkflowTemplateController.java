package com.example.demo.controller;

import com.example.demo.model.WorkflowTemplate;
import com.example.demo.repository.WorkflowTemplateRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/templates")
public class WorkflowTemplateController {

    private final WorkflowTemplateRepository repository;

    public WorkflowTemplateController(WorkflowTemplateRepository repository) {
        this.repository = repository;
    }

    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate template) {
        return repository.save(template);
    }


    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return repository.findAll();
    }

    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }


    @PutMapping("/{id}")
    public WorkflowTemplate update(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate newData) {

        WorkflowTemplate old = repository.findById(id).orElse(null);

        if (old != null) {
            old.setTemplateName(newData.getTemplateName());
            old.setDescription(newData.getDescription());
            old.setTotalLevels(newData.getTotalLevels());
            old.setActive(newData.getActive());
            return repository.save(old);
        }
        return null;
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        repository.deleteById(id);
        return "Deleted successfully";
    }
}
