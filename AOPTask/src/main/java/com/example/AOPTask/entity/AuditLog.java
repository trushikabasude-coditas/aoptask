package com.example.AOPTask.entity;

import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AuditLog {

        private Long userId;
        private String action;
        private String method;

        public AuditLog(Long userId, String action, String method, Date timestamp) {
            this.userId = userId;
            this.action = action;
            this.method = method;
        }

        public Long getUserId() { return userId; }
        public String getAction() { return action; }
        public String getMethod() { return method; }
    }

