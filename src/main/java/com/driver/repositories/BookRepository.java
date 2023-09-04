package com.driver.repositories;

import com.driver.model.Booking;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Objects;

@Repository
public class BookRepository {


    HashMap<String,Booking> BookingDb = new HashMap<>();

    HashMap<Integer,Integer> countOfBookingsDb = new HashMap<>();

    public void addBookingDb(String key, Booking booking) {

        BookingDb.put(key,booking);

    }

    public int bookingCount(int adharcard)
    {
        int count = countOfBookingsDb.get(adharcard);

        return count;
    }

    public void addBookingCount(int aadharCard, Integer currentBookings) {

        countOfBookingsDb.put(aadharCard, Objects.nonNull(currentBookings)?1+currentBookings:1);
    }

    public int getBooking(Integer aadharCard) {

        int count = countOfBookingsDb.get(aadharCard);
        return count;
    }
}
