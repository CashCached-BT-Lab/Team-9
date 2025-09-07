package com.zenith.customeraudit.customer;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

@RestController
@RequestMapping("/api/customers")
@RequiredArgsConstructor
public class CustomerProfileController {

    private final CustomerProfileRepository repository;

    @PostMapping
    public ResponseEntity<CustomerProfile> create(@RequestBody CustomerProfile profile) {
        return ResponseEntity.ok(repository.save(profile));
    }

    @GetMapping
    public Page<CustomerProfile> findAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CustomerProfile> findById(@PathVariable("id") Long id) {
        return repository.findById(id)
                .map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CustomerProfile> update(@PathVariable Long id, @RequestBody CustomerProfile updated) {
        return repository.findById(id)
                .map(existing -> {
                    updated.setCustomerId(existing.getCustomerId());
                    return ResponseEntity.ok(repository.save(updated));
                })
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        if (!repository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/search/by-custid")
    public Page<CustomerProfile> searchByCustId(@RequestParam("q") String q, Pageable pageable) {
        return repository.findByCustomerIdItemContainingIgnoreCase(q, pageable);
    }

    @GetMapping("/search/by-email")
    public Page<CustomerProfile> searchByEmail(@RequestParam("q") String q, Pageable pageable) {
        return repository.findByEmailContainingIgnoreCase(q, pageable);
    }

    @GetMapping("/search/by-mobile")
    public Page<CustomerProfile> searchByMobile(@RequestParam("q") String q, Pageable pageable) {
        return repository.findByMobileContaining(q, pageable);
    }
}



