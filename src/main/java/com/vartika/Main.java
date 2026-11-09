package com.vartika;

import com.vartika.Booking.Seat;

public class Main {
	public static void main(String[] args) {
		
		System.out.println("Hello, World!");
		Seat seat = new Seat("ABC");
		boolean a = seat.holdSeat("bookingId1");
		boolean n = seat.holdSeat("bookingId2");
		boolean b = seat.confirmBooking("bookingId2");
		boolean c = seat.confirmBooking("bookingId1");
		System.out.println(a);
		System.out.println(n);
		System.out.println(b);
		System.out.println(c);
	}
}