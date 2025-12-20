package com.example.demo.controller;

import com.example.demo.model.ApprovalRequest;
import com.example.demo.service.ApprovalRequestService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/requests")
public class ApprovalRequestController {

    private ApprovalRequestService service;

    public ApprovalRequestController(ApprovalRequestService service) {
        this.service = service;
    }

    @PostMapping
    public ApprovalRequest save(@RequestBody ApprovalRequest request) {
        return service.save(request);
    }

    @GetMapping("/{id}")
    public ApprovalRequest get(@PathVariable Long id) {
        return service.getById(id);
    }

    @GetMapping
    public List<ApprovalRequest> getAll() {
        return service.getAll();
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
