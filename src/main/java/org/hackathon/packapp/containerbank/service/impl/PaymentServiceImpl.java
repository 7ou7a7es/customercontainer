package org.hackathon.packapp.containerbank.service.impl;

import java.util.Collection;

import org.hackathon.packapp.containerbank.model.Payment;
import org.hackathon.packapp.containerbank.repository.PaymentRepository;
import org.hackathon.packapp.containerbank.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PaymentServiceImpl implements PaymentService {
	
	private PaymentRepository paymentRepository;

	@Autowired
	public PaymentServiceImpl(PaymentRepository paymentRepository) {
		this.paymentRepository = paymentRepository;
	}

	@Override
	@Transactional
	public void savePayment(Payment payment) throws DataAccessException {
		long startTime = System.currentTimeMillis();
		paymentRepository.save(payment);
		System.out.println("*** customercontainer PaymentServiceImpl method save payment id "+payment.getId()+" time : " + (System.currentTimeMillis() - startTime));
	}

	@Override
	public Collection<Payment> findPaymentsByCardId(int cardId) {
		long startTime = System.currentTimeMillis();
		Collection<Payment> result =  paymentRepository.findByCardId(cardId);
		System.out.println("*** customercontainer PaymentServiceImpl method findPaymentsByCardId on id "+cardId+" time : " + (System.currentTimeMillis() - startTime));
		return result;
	}

}
