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

    // ✅ CREATE (avoid duplicate)
    @PostMapping
    public WorkflowTemplate create(@RequestBody WorkflowTemplate template) {

        // 🔴 DUPLICATE CHECK
        if (repository.existsByTemplateName(template.getTemplateName())) {
            throw new RuntimeException(
                    "Template with name '" + template.getTemplateName() + "' already exists");
        }

        return repository.save(template);
    }

    // ✅ READ ALL
    @GetMapping
    public List<WorkflowTemplate> getAll() {
        return repository.findAll();
    }

    // ✅ READ BY ID
    @GetMapping("/{id}")
    public WorkflowTemplate getById(@PathVariable Long id) {
        return repository.findById(id).orElse(null);
    }

    // ✅ UPDATE (avoid duplicate)
    @PutMapping("/{id}")
    public WorkflowTemplate update(
            @PathVariable Long id,
            @RequestBody WorkflowTemplate newData) {

        WorkflowTemplate old = repository.findById(id).orElse(null);

        if (old != null) {

            if (!old.getTemplateName().equals(newData.getTemplateName()) &&
                repository.existsByTemplateName(newData.getTemplateName())) {

                throw new RuntimeException(
                        "Template with name '" + newData.getTemplateName() + "' already exists");
            }

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
