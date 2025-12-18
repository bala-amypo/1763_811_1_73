package com.example.demo.controller;

import com.example.demo.entity.ApprovalAction;
import com.example.demo.service.ApprovalActionService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/actions")
public class ApprovalActionController {

    private final ApprovalActionService service;

    public ApprovalActionController(ApprovalActionService service) {
        this.service = service;
    }

    @PostMapping
    public ApprovalAction act(@RequestBody ApprovalAction action) {
        return service.recordAction(action);
    }
}
