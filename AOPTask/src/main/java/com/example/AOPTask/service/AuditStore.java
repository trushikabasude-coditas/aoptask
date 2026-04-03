package com.example.AOPTask.service;

import com.example.AOPTask.entity.AuditLog;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class AuditStore {

    private List<AuditLog> logs = new ArrayList<>();

    public void addLog(AuditLog log) {
        logs.add(log);
    }

    public List<AuditLog> getLogs() {
        return logs;
    }
}
{
}
