package com.ntt.testntt.core.application.repositories;

import com.ntt.testntt.core.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    Optional<Customer> findByCustomerIdAndTipoDocumento(Long aLong, char tipoDocumento);
}
