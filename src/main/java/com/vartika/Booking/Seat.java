package com.vartika.Booking;

import com.vartika.utils.SeatStatus;

import java.time.Duration;
import java.time.Instant;

public class Seat {
	private final String seatId;
	
	private SeatStatus seatStatus;
	private String heldByBookingId;
	private Instant holdExpiresAt;
	
	public Seat(String seatId) {
		this.seatId = seatId;
		this.seatStatus = SeatStatus.AVAILABLE;
	}
	
	public String getSeatId() {
		return seatId;
	}
	
	public SeatStatus getStatus() {
		return seatStatus;
	}
	
	public synchronized boolean holdSeat(String bookingId){
		
		//released an expired hold
		if ( seatStatus == SeatStatus.HELD && holdExpiresAt!=null && Instant.now().isAfter(holdExpiresAt)){
			seatStatus = SeatStatus.AVAILABLE;
			heldByBookingId = null;
			holdExpiresAt = null;
		}
		
		// check if still held ie valid hold
		
		if(seatStatus != SeatStatus.AVAILABLE)
			return false;
		
		seatStatus = SeatStatus.HELD;
		heldByBookingId = bookingId;
		holdExpiresAt = Instant.now().plus(Duration.ofMinutes(5));
		
		return true;
	}
	
	public synchronized boolean confirmBooking(String bookingId){
		if(seatStatus != SeatStatus.HELD || !bookingId.equals(heldByBookingId)) {
			return false;
		}
		// do not process expired hold
		if ( holdExpiresAt==null || Instant.now().isAfter(holdExpiresAt)){
			return false;
		}
		seatStatus = SeatStatus.BOOKED;
		holdExpiresAt = null;
		return true;
	}
}
