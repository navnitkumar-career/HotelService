package com.example.Service.ser;

import java.util.List;

import com.example.Service.entites.Hotel;

public interface HotelService {
	
	Hotel CREATE(Hotel hotel);
	
	List<Hotel> getAll();
	
	Hotel getById(String id); 

}
