package com.zenith.customeraudit.audit;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.Instant;

@Entity
@Table(name = "AUDIT_LOG")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuditLog {

    @Id
    @Column(name = "AUDIT_UUID", length = 100)
    private String auditUuid;

    @Column(name = "CRUD_VALUE", nullable = false, length = 1)
    private String crudValue;

    @Column(name = "USER_ID", nullable = false, length = 100)
    private String userId;

    @Column(name = "WS_ID", length = 100)
    private String workstationId;

    @Column(name = "PRGM_ID", length = 100)
    private String programId;

    @Column(name = "HOST_TS")
    private Instant hostTimestamp;

    @Column(name = "LOCAL_TS")
    private Instant localTimestamp;

    @Column(name = "ACPT_TS")
    private Instant acceptedTimestamp;

    @Column(name = "ACPT_TS_UTC_OFST", length = 10)
    private String acceptedTimestampUtcOffset;

    @Column(name = "CHANGED_FIELDS", columnDefinition = "JSON")
    private String changedFieldsJson;

    @Column(name = "REMARKS", columnDefinition = "TEXT")
    private String remarks;
}



