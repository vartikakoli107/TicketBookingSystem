package com.vartika.service;

import com.vartika.Booking.Booking;
import com.vartika.exception.SeatUnavailableException;
import com.vartika.repositories.BookingRepository;

import java.time.Instant;
import java.util.UUID;

public class BookingService {
	SeatService seatService;
	BookingRepository bookingRepository;
	
	public BookingService(SeatService seatService, BookingRepository bookingRepository){
		this.bookingRepository = bookingRepository;
		this.seatService = seatService;
	}
	
	public Booking createBooking(String userId, String seatId, String idempotencyKey){
		
		Booking existing = bookingRepository.findByKey(idempotencyKey);
		
		if (existing!= null){
			return existing;
		}
		
		String bookingId = UUID.randomUUID().toString();
		
		boolean held = seatService.holdSeat(bookingId, seatId);
		
		if(!held) {
		 throw new SeatUnavailableException("Seat" + seatId +  " could not be held");
		}
		
		Booking booking = new Booking(bookingId, userId, seatId, idempotencyKey);
		
		return bookingRepository.save(booking);
		
		
	}
}
