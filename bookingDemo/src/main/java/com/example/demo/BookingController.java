package com.example.demo;

import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping(value = "/bookings")
public class BookingController {


    private List<HotelBooking> bookings;

    public BookingController()
    {
        bookings = new ArrayList<>();
        bookings.add(new HotelBooking("Mariott",253,23));
        bookings.add(new HotelBooking("Mariott - Mumbai",255,2));
        bookings.add(new HotelBooking("Mariott Delhi",250,231));
        bookings.add(new HotelBooking("Mariott Raleigh",256,236));

    }


    @RequestMapping(value = "/all",method = RequestMethod.GET)
    public List<HotelBooking> getAll()
    {
        return  bookings;
    }

    @RequestMapping(value = "/affordable/{price}",method = RequestMethod.GET)
    public List<HotelBooking> getAffordable(@PathVariable double price)
    {
        return bookings.stream().filter(x -> x.getPricePerNight() <= price).collect(Collectors.toList());
    }

    @RequestMapping(value = "/create",method = RequestMethod.POST)
    public List<HotelBooking> create(@RequestBody HotelBooking hotelBooking)
    {
        bookings.add(hotelBooking);
        return bookings;
    }
}
