package com.zenith.customeraudit.customer;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface CustomerProfileRepository extends JpaRepository<CustomerProfile, Long> {
    Optional<CustomerProfile> findByCustomerIdItem(String customerIdItem);

    Page<CustomerProfile> findAll(Pageable pageable);

    Page<CustomerProfile> findByCustomerIdItemContainingIgnoreCase(String customerIdItem, Pageable pageable);

    Page<CustomerProfile> findByEmailContainingIgnoreCase(String email, Pageable pageable);

    Page<CustomerProfile> findByMobileContaining(String mobile, Pageable pageable);
}



