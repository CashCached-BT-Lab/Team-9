package com.zenith.customeraudit.customer;

import com.zenith.customeraudit.audit.AuditLog;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Table(name = "CUSTOMER_PROFILE")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CustomerProfile {

    @Id
    @Column(name = "CST_ID")
    private Long customerId;

    @Column(name = "CUSTID_TYPE", length = 100)
    private String customerIdType;

    @Column(name = "CUSTID_ITEM", length = 100, nullable = false, unique = true)
    private String customerIdItem;

    @Column(name = "CSTDET_TYPE", length = 100)
    private String customerType;

    @Column(name = "CSTDET_DOB")
    private LocalDate dateOfBirth;

    @Column(name = "CSTDET_STATUS", length = 100)
    private String status;

    @Column(name = "CSTDET_MOBILE", length = 100)
    private String mobile;

    @Column(name = "CSTDET_EMAIL", length = 100)
    private String email;

    @Column(name = "CSTNAME_FIRST", length = 100)
    private String firstName;

    @Column(name = "CSTNAME_MIDDLE", length = 100)
    private String middleName;

    @Column(name = "CSTNAME_LAST", length = 100)
    private String lastName;

    @Column(name = "CSTADD_PERMANENT", length = 200)
    private String permanentAddress;

    @Column(name = "CSTADD_CURRENT", length = 200)
    private String currentAddress;

    @Column(name = "CSTPOI_TYPE", length = 100)
    private String proofOfIdentityType;

    @Column(name = "CSTPOI_VALUE", length = 100, unique = true)
    private String proofOfIdentityValue;

    @Column(name = "CSTPOI_START")
    private LocalDate proofOfIdentityStart;

    @Column(name = "CSTPOI_END")
    private LocalDate proofOfIdentityEnd;

    @Column(name = "CONTACT_TYPE", length = 50)
    private String contactType;

    @Column(name = "CONTACT_VALUE", length = 100)
    private String contactValue;

    @Column(name = "CST_EFCTV_DATE", nullable = false)
    private LocalDate effectiveDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "AUDIT_UUID")
    private AuditLog auditLog;

    @Column(name = "AUDIT_DETAILS", columnDefinition = "JSON")
    private String auditDetailsJson;
}



