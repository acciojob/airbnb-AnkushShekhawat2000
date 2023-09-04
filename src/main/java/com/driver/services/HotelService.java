package com.driver.services;

import com.driver.model.Facility;
import com.driver.model.Hotel;
import com.driver.repositories.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class HotelService {

    @Autowired
    HotelRepository hotelRepository;
    public String addHotel(Hotel hotel) {

        String ans = hotelRepository.addHotel(hotel);
        return ans;
    }

    public String getHotelWithMostFacilities() {

        int facilities = 0;

        List<Hotel> list = hotelRepository.getHotelWithMostFacilities();

        String hotelName = "";

        for(Hotel hotel : list)
        {
            if(hotel.getFacilities().size() > facilities)
            {
                facilities = hotel.getFacilities().size();
                hotelName = hotel.getHotelName();

            }
            else if(hotel.getFacilities().size() == facilities)
            {
                if(hotel.getHotelName().compareTo(hotelName)<0)
                {
                    hotelName = hotel.getHotelName();
                }
            }
        }
        return hotelName;

    }

    public Hotel getHotelWithMostFacilities(List<Facility> newFacilities, String hotelName) {

        List<Facility> oldFacilities = hotelRepository.getFacility(hotelName);

        for(Facility facility : newFacilities)
        {
            if(oldFacilities.contains(facility))
            {
                continue;
            }
            else {
                oldFacilities.add(facility);
            }
        }

        Hotel hotel = hotelRepository.getHotelName(hotelName);

        hotel.setFacilities(oldFacilities);

        hotelRepository.setHotelDb(hotelName,hotel);

        return hotel;


    }
}
