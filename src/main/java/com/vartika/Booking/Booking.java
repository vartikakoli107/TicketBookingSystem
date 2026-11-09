package com.vartika.Booking;

import com.vartika.utils.BookingStatus;
import com.vartika.utils.PaymentStatus;

import java.time.Instant;

public class Booking {
	private final String bookingId;
	private final String userId;
	private final String seatId;
	private final String idempotencyKey;
	private final Instant createdAt;
	
	
	private PaymentStatus paymentStatus;
	private BookingStatus bookingStatus;
	
	public Booking(String bookingId, String userId, String seatId, String idempotencyKey){
		this.bookingId = bookingId;
		this.userId = userId;
		this.seatId = seatId;
		this.idempotencyKey = idempotencyKey;
		this.createdAt = Instant.now();
		
		this.paymentStatus = PaymentStatus.PENDING;
		this.bookingStatus = BookingStatus.PENDING;
	}
	
	public BookingStatus getBookingStatus() {
		return bookingStatus;
	}
	
	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}
	
	public String getSeatId() {
		return seatId;
	}
	
	public String getIdempotencyKey(){
		return idempotencyKey;
	}
	
	public String getBookingId() {
		return bookingId;
	}

	public String getUserId() {
		return userId;
	}
	
	public void setBookingStatus(BookingStatus bookingStatus) {
		this.bookingStatus = bookingStatus;
	}
	
	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
}
