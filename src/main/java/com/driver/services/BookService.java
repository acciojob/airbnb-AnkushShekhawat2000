package com.driver.services;


import com.driver.model.Booking;
import com.driver.model.Hotel;
import com.driver.repositories.BookRepository;
import com.driver.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.UUID;

@Service
public class BookService {



    @Autowired
    BookRepository bookRepository;

    @Autowired
    HotelRepository hotelRepository;


    public int bookARoom(Booking booking) {

        String key = UUID.randomUUID().toString();

        booking.setBookingId(key);

        String hotelName = booking.getHotelName();

        Hotel hotel = hotelRepository.find(hotelName);

        int avilableRooms = hotel.getAvailableRooms();

        if(avilableRooms < booking.getNoOfRooms())
        {
            return -1;
        }


        int amountToBePaid = hotel.getPricePerNight()*booking.getNoOfRooms();
        booking.setAmountToBePaid(amountToBePaid);

        hotel.setAvailableRooms(hotel.getAvailableRooms());


       bookRepository.addBookingDb(key,booking);

       hotelRepository.addHotelDb(hotelName, hotel);


       int aadharCard  = booking.getBookingAadharCard();

       Integer currentBookings = bookRepository.bookingCount(aadharCard);

       // add count in booking
        bookRepository.addBookingCount(aadharCard,currentBookings);

        return amountToBePaid;



    }

    public int getBookings(Integer aadharCard) {

        int count = bookRepository.getBooking(aadharCard);
        return count;

    }
}
