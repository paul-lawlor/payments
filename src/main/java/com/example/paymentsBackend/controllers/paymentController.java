package com.example.paymentsBackend.controllers;

import com.example.paymentsBackend.models.Payment;
import com.example.paymentsBackend.repositories.IPaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityNotFoundException;
import java.util.List;

@RestController
public class paymentController {

    @Autowired
    private IPaymentRepository repository;

    @GetMapping("/payments")
    public List<Payment> getPayments() { return repository.findAll();}

    @PostMapping("/payments")
    public Payment postPayment(@RequestBody Payment payment) {
        repository.save(payment);
        return repository.save(payment);
    }

    @PutMapping("/payments/{id}")
    public Payment updatePayment(@PathVariable int id, @Validated @RequestBody Payment paymentRequest) {
        return repository.findById(id)
                .map(payment -> {
                    if (paymentRequest.getOrderID() != null ){
                        payment.setOrderID(paymentRequest.getOrderID());
                    }
                    if (paymentRequest.getPaymentType() != null) {
                        payment.setPaymentType(paymentRequest.getPaymentType());
                    }
                    return repository.save(payment);
                }).orElseThrow(() -> new EntityNotFoundException("No payment found with ID " + id));
                    }

    @DeleteMapping("/payments/{id}")
    public String deletePayment(@PathVariable Integer id){
        repository.deleteById(id);
        return "Payment Deleted";
    }
    }


