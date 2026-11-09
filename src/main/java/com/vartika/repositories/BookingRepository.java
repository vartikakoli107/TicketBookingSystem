package com.vartika.repositories;

import com.vartika.Booking.Booking;
import com.vartika.Booking.Seat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class BookingRepository {

	public final Map<String, Booking> bookingById = new ConcurrentHashMap<>();
	public final Map<String, Booking> bookingByIdempotencyKey = new ConcurrentHashMap<>();
	
	public Booking findById(String bookingId){
		return bookingById.get(bookingId);
	}
	
	public Booking findByKey(String key){
		return bookingByIdempotencyKey.get(key);
	}
	
	public Booking save( Booking booking){
		bookingById.put(booking.getBookingId(), booking);
		bookingByIdempotencyKey.put(booking.getIdempotencyKey(), booking);
		return booking;
	}
}
