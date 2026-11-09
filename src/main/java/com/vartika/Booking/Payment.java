package com.vartika.Booking;

import com.vartika.utils.PaymentStatus;

import java.time.Instant;

public class Payment {

	private final String paymentId;
	private final String bookingId;
	private final Instant createdAt;
	private final String idempotencyKey;
	private final int amountInPaise;
	
	private PaymentStatus status;
	
	public Payment(String paymentId, String bookingId, String idempotencyKey, int amountInPaise) {
		this.paymentId = paymentId;
		this.bookingId = bookingId;
		this.createdAt = Instant.now();
		this.idempotencyKey = idempotencyKey;
		this.amountInPaise = amountInPaise;
		this.status = PaymentStatus.PENDING;
	}
	
	public String getBookingId() {
		return bookingId;
	}
	
	public String getPaymentId() {
		return paymentId;
	}
	
	public int getAmountInPaise(){
		return amountInPaise;
	}
	
	public PaymentStatus getStatus() {
		return status;
	}
	
	public void setStatus(PaymentStatus status){
		this.status = status;
	}
}
