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
    public ApprovalRequest create(@RequestBody ApprovalRequest request) {
        return service.createRequest(request);
    }

    @GetMapping("/{id}")
    public ApprovalRequest get(@PathVariable Long id) {
        return service.getRequestById(id);
    }

    @GetMapping
    public List<ApprovalRequest> getAll() {
        return service.getAllRequests();
    }

    @GetMapping("/requester/{id}")
    public List<ApprovalRequest> getByRequester(@PathVariable Long id) {
        return service.getRequestsByRequester(id);
    }

    @DeleteMapping("/{id}")
    public String delete(@PathVariable Long id) {
        service.deleteRequest(id);
        return "Request deleted successfully";
    }
}
