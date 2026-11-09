package com.vartika.service;

import com.vartika.Booking.Seat;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class SeatService {

	private final Map<String, Seat> seats = new ConcurrentHashMap<>();
	
	//add a seat
	public void addSeat(Seat seat){
		seats.put(seat.getSeatId(), seat);
	}
	
	//get a seat
	public Seat getSeat(String seatId){
		return seats.get(seatId);
	}
	
	public boolean holdSeat(String bookingId, String seatId){
		
		Seat seat = seats.get(seatId);
		if(seat == null)
			return false;
		
		
		return seat.holdSeat(bookingId);
	}
	
}
