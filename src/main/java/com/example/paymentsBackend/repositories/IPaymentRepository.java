package com.example.paymentsBackend.repositories;

import com.example.paymentsBackend.models.Payment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPaymentRepository extends JpaRepository<Payment, Integer> {
}
