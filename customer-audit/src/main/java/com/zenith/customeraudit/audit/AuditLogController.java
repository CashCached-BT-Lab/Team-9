package com.zenith.customeraudit.audit;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/audits")
@RequiredArgsConstructor
public class AuditLogController {

    private final AuditLogRepository auditLogRepository;

    @PostMapping
    public ResponseEntity<AuditLog> create(@RequestBody AuditLog auditLog) {
        return ResponseEntity.ok(auditLogRepository.save(auditLog));
    }

    @GetMapping
    public List<AuditLog> findAll() {
        return auditLogRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<AuditLog> findById(@PathVariable("id") String id) {
        return auditLogRepository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<AuditLog> update(@PathVariable String id, @RequestBody AuditLog updated) {
        return auditLogRepository.findById(id)
                .map(existing -> {
                    updated.setAuditUuid(existing.getAuditUuid());
                    return ResponseEntity.ok(auditLogRepository.save(updated));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        if (!auditLogRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        auditLogRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}



