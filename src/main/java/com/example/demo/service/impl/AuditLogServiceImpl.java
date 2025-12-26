package com.example.demo.service.impl;

import com.example.demo.model.AuditLogRecord;
import com.example.demo.repository.AuditLogRecordRepository;
import com.example.demo.service.AuditLogService;
import org.springframework.stereotype.Service;

@Service
public class AuditLogServiceImpl implements AuditLogService {

    private final AuditLogRecordRepository repo;

    public AuditLogServiceImpl(AuditLogRecordRepository repo) {
        this.repo = repo;
    }

    public AuditLogRecord save(AuditLogRecord log) {
        return repo.save(log);
    }
}
