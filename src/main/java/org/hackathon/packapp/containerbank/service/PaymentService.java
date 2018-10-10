package org.hackathon.packapp.containerbank.service;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Payment;
import org.springframework.dao.DataAccessException;

public interface PaymentService {

	void savePayment(Payment payment) throws DataAccessException;

	Collection<Payment> findPaymentsByCardId(int cardId);

}
