# BT Lab Banking System - ER Diagrams Documentation

## Overview
This document outlines the Entity-Relationship (ER) diagrams for the BT Lab Banking System, focusing on the Customer and FD Simulator modules.

## 1. Customer Module ER Diagram

### Primary Entities

#### 1.1 Customer Entity
```
Customer {
  customer_id: BIGINT (PK, Auto-generated with Check Digit)
  customer_number: VARCHAR(20) (Unique, Check Digit Algorithm)
  first_name: VARCHAR(100)
  last_name: VARCHAR(100)
  date_of_birth: DATE
  gender: ENUM('MALE', 'FEMALE', 'OTHER')
  nationality: VARCHAR(50)
  email: VARCHAR(255) (Unique)
  phone_number: VARCHAR(20)
  preferred_language: ENUM('ENGLISH', 'JAPANESE')
  preferred_currency: ENUM('INR', 'KWD', 'JPY')
  customer_status: ENUM('ACTIVE', 'INACTIVE', 'SUSPENDED', 'CLOSED')
  customer_tier: ENUM('PLATINUM', 'GOLD', 'SILVER', 'BRONZE')
  risk_profile: ENUM('CONSERVATIVE', 'MODERATE', 'AGGRESSIVE')
  kyc_status: ENUM('PENDING', 'VERIFIED', 'REJECTED')
  created_date: TIMESTAMP
  last_modified_date: TIMESTAMP
  created_by: VARCHAR(100)
  modified_by: VARCHAR(100)
  version: INT
}
```

#### 1.2 Customer Address Entity
```
CustomerAddress {
  address_id: BIGINT (PK)
  customer_id: BIGINT (FK -> Customer)
  address_type: ENUM('HOME', 'OFFICE', 'MAILING', 'PERMANENT')
  street_address: VARCHAR(255)
  city: VARCHAR(100)
  state: VARCHAR(100)
  country: VARCHAR(100)
  postal_code: VARCHAR(20)
  is_primary: BOOLEAN
  created_date: TIMESTAMP
  last_modified_date: TIMESTAMP
  version: INT
}
```

#### 1.3 Customer Document Entity
```
CustomerDocument {
  document_id: BIGINT (PK)
  customer_id: BIGINT (FK -> Customer)
  document_type: ENUM('PASSPORT', 'DRIVING_LICENSE', 'NATIONAL_ID', 'PAN_CARD', 'AADHAR')
  document_number: VARCHAR(50)
  issuing_authority: VARCHAR(100)
  issue_date: DATE
  expiry_date: DATE
  document_status: ENUM('VALID', 'EXPIRED', 'PENDING_VERIFICATION')
  document_file_path: VARCHAR(500)
  created_date: TIMESTAMP
  last_modified_date: TIMESTAMP
  version: INT
}
```

#### 1.4 Customer Communication Entity
```
CustomerCommunication {
  communication_id: BIGINT (PK)
  customer_id: BIGINT (FK -> Customer)
  communication_type: ENUM('EMAIL', 'SMS', 'PHONE', 'LETTER')
  communication_channel: VARCHAR(50)
  subject: VARCHAR(255)
  message: TEXT
  status: ENUM('SENT', 'DELIVERED', 'READ', 'FAILED')
  sent_date: TIMESTAMP
  delivered_date: TIMESTAMP
  read_date: TIMESTAMP
  created_date: TIMESTAMP
  version: INT
}
```

#### 1.5 Customer Account Entity
```
CustomerAccount {
  account_id: BIGINT (PK)
  customer_id: BIGINT (FK -> Customer)
  account_number: VARCHAR(50) (Unique, Check Digit Algorithm)
  account_type: ENUM('SAVINGS', 'CURRENT', 'FD', 'RD')
  currency: ENUM('INR', 'KWD', 'JPY')
  balance: DECIMAL(20,2)
  available_balance: DECIMAL(20,2)
  account_status: ENUM('ACTIVE', 'INACTIVE', 'FROZEN', 'CLOSED')
  opening_date: DATE
  closing_date: DATE
  created_date: TIMESTAMP
  last_modified_date: TIMESTAMP
  version: INT
}
```

### Relationships
- Customer (1) → CustomerAddress (N)
- Customer (1) → CustomerDocument (N)
- Customer (1) → CustomerCommunication (N)
- Customer (1) → CustomerAccount (N)

## 2. FD Simulator Module ER Diagram

### Primary Entities

#### 2.1 FD Product Entity
```
FDProduct {
  product_id: BIGINT (PK)
  product_code: VARCHAR(20) (Unique)
  product_name: VARCHAR(100)
  product_description: TEXT
  currency: ENUM('INR', 'KWD', 'JPY')
  min_amount: DECIMAL(20,2)
  max_amount: DECIMAL(20,2)
  min_tenure_months: INT
  max_tenure_months: INT
  base_interest_rate: DECIMAL(5,2)
  compounding_frequency: ENUM('DAILY', 'MONTHLY', 'QUARTERLY', 'HALF_YEARLY', 'ANNUALLY')
  early_withdrawal_penalty: DECIMAL(5,2)
  auto_renewal_allowed: BOOLEAN
  tax_deductible: BOOLEAN
  product_status: ENUM('ACTIVE', 'INACTIVE', 'DISCONTINUED')
  eligibility_criteria: TEXT
  created_date: TIMESTAMP
  last_modified_date: TIMESTAMP
  version: INT
}
```

#### 2.2 FD Rate Tier Entity
```
FDRateTier {
  tier_id: BIGINT (PK)
  product_id: BIGINT (FK -> FDProduct)
  tier_name: VARCHAR(50)
  min_amount: DECIMAL(20,2)
  max_amount: DECIMAL(20,2)
  interest_rate: DECIMAL(5,2)
  effective_from: DATE
  effective_to: DATE
  created_date: TIMESTAMP
  version: INT
}
```

#### 2.3 FD Simulation Entity
```
FDSimulation {
  simulation_id: BIGINT (PK)
  customer_id: BIGINT (FK -> Customer)
  product_id: BIGINT (FK -> FDProduct)
  principal_amount: DECIMAL(20,2)
  currency: ENUM('INR', 'KWD', 'JPY')
  tenure_months: INT
  interest_rate: DECIMAL(5,2)
  compounding_frequency: ENUM('DAILY', 'MONTHLY', 'QUARTERLY', 'HALF_YEARLY', 'ANNUALLY')
  maturity_amount: DECIMAL(20,2)
  total_interest: DECIMAL(20,2)
  effective_annual_rate: DECIMAL(5,2)
  customer_tier_bonus: DECIMAL(5,2)
  relationship_bonus: DECIMAL(5,2)
  simulation_date: TIMESTAMP
  created_date: TIMESTAMP
  version: INT
}
```

#### 2.4 FD Account Entity
```
FDAccount {
  fd_account_id: BIGINT (PK)
  customer_id: BIGINT (FK -> Customer)
  product_id: BIGINT (FK -> FDProduct)
  account_number: VARCHAR(50) (Unique, Check Digit Algorithm)
  principal_amount: DECIMAL(20,2)
  currency: ENUM('INR', 'KWD', 'JPY')
  interest_rate: DECIMAL(5,2)
  compounding_frequency: ENUM('DAILY', 'MONTHLY', 'QUARTERLY', 'HALF_YEARLY', 'ANNUALLY')
  opening_date: DATE
  maturity_date: DATE
  tenure_months: INT
  maturity_amount: DECIMAL(20,2)
  accrued_interest: DECIMAL(20,2)
  account_status: ENUM('ACTIVE', 'MATURED', 'PREMATURE_CLOSED', 'RENEWED')
  auto_renewal: BOOLEAN
  created_date: TIMESTAMP
  last_modified_date: TIMESTAMP
  version: INT
}
```

#### 2.5 FD Transaction Entity
```
FDTransaction {
  transaction_id: BIGINT (PK)
  fd_account_id: BIGINT (FK -> FDAccount)
  transaction_type: ENUM('OPENING', 'INTEREST_ACCRUAL', 'INTEREST_CAPITALIZATION', 'PREMATURE_CLOSURE', 'MATURITY_PAYOUT', 'RENEWAL')
  transaction_amount: DECIMAL(20,2)
  currency: ENUM('INR', 'KWD', 'JPY')
  transaction_date: DATE
  reference_number: VARCHAR(50)
  description: VARCHAR(255)
  created_date: TIMESTAMP
  version: INT
}
```

### Relationships
- FDProduct (1) → FDRateTier (N)
- Customer (1) → FDSimulation (N)
- FDProduct (1) → FDSimulation (N)
- Customer (1) → FDAccount (N)
- FDProduct (1) → FDAccount (N)
- FDAccount (1) → FDTransaction (N)

## 3. Common Audit Entities

#### 3.1 Audit Log Entity
```
AuditLog {
  audit_id: BIGINT (PK)
  entity_type: VARCHAR(50)
  entity_id: BIGINT
  action: ENUM('CREATE', 'UPDATE', 'DELETE', 'READ')
  old_values: JSON
  new_values: JSON
  user_id: VARCHAR(100)
  ip_address: VARCHAR(45)
  user_agent: VARCHAR(500)
  created_date: TIMESTAMP
}
```

## 4. Database Indexes

### Customer Module Indexes
- `idx_customer_email` ON Customer(email)
- `idx_customer_phone` ON Customer(phone_number)
- `idx_customer_status` ON Customer(customer_status)
- `idx_customer_tier` ON Customer(customer_tier)
- `idx_customer_created_date` ON Customer(created_date)

### FD Module Indexes
- `idx_fd_product_code` ON FDProduct(product_code)
- `idx_fd_product_status` ON FDProduct(product_status)
- `idx_fd_account_number` ON FDAccount(account_number)
- `idx_fd_maturity_date` ON FDAccount(maturity_date)
- `idx_fd_account_status` ON FDAccount(account_status)

## 5. Constraints

### Primary Key Constraints
- All entities have BIGINT primary keys with auto-increment
- Customer and FDAccount use Check Digit algorithm for account numbers

### Foreign Key Constraints
- All foreign keys have CASCADE DELETE restrictions
- Referential integrity maintained across all relationships

### Unique Constraints
- Customer email and phone number
- Account numbers (with Check Digit validation)
- Product codes
- Document numbers per customer

### Check Constraints
- Interest rates must be positive
- Amounts must be positive
- Dates must be valid
- Status values must be from defined enums

## 6. Data Types and Precision

### Monetary Values
- All monetary values use DECIMAL(20,2) for precision
- Currency codes use ENUM for data integrity

### Dates and Timestamps
- Business dates use DATE type
- Audit timestamps use TIMESTAMP type
- All dates stored in UTC timezone

### Text Fields
- Names: VARCHAR(100)
- Descriptions: TEXT
- Codes: VARCHAR(20)
- Numbers: VARCHAR(50)

This ER diagram design ensures data integrity, performance, and scalability for the BT Lab Banking System's Customer and FD Simulator modules. 