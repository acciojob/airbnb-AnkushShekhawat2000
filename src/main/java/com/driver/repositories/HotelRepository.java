package com.driver.repositories;

import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.services.BookService;
import com.driver.services.HotelService;
import com.driver.services.UserService;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public class HotelRepository {


    HotelService hotelService = new HotelService();

    BookService bookService = new BookService();

    UserService userService = new UserService();
    HashMap<String, Hotel> HotelDb = new HashMap<>();
    public String addHotel(Hotel hotel) {
        if(hotel == null || hotel.getHotelName() == null)
        {
            return "FAILURE";
        }
        else if(hotelService.already(hotel.getHotelName()))
        {
            return "FAILURE";
        }

        HotelDb.put(hotel.getHotelName(),hotel);
        return "SUCCESS";
    }

    public List<Hotel> getHotelWithMostFacilities() {

        List<Hotel> list = new ArrayList<>();

        for(Hotel hotel : HotelDb.values())
        {
            list.add(hotel);
        }

        return list;
    }

    public Hotel find(String hotelName) {

        Hotel hotel = HotelDb.get(hotelName);

        return hotel;

    }

    public void addHotelDb(String hotelName, Hotel hotel) {

        HotelDb.put(hotelName,hotel);



    }

    public List<Facility> getFacility(String hotelName) {

        List<Facility> oldFacilities = HotelDb.get(hotelName).getFacilities();

        return oldFacilities;

    }

    public Hotel getHotelName(String hotelName) {
        return HotelDb.get(hotelName);
    }

    public void setHotelDb(String hotelName, Hotel hotel) {

        HotelDb.put(hotelName,hotel);
    }

    public Boolean already(String hotelName) {

        return HotelDb.containsKey(hotelName);
    }
}
