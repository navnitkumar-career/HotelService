package com.example.Service.Impl;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Service.Exception.ResourceNotFoundException;
import com.example.Service.entites.Hotel;
import com.example.Service.repositories.HotelRepo;
import com.example.Service.ser.HotelService;

@Service
public class HotelServiceImpl implements HotelService {

	@Autowired
	HotelRepo hotelRepo;

	@Override
	public Hotel CREATE(Hotel hotel) {
		String hotelId = UUID.randomUUID().toString();
		hotel.setId(hotelId);
		return hotelRepo.save(hotel);
	}

	@Override
	public List<Hotel> getAll() {
		
		return hotelRepo.findAll();
	}

	@Override
	public Hotel getById(String id) {
		
		return hotelRepo.findById(id).get();
	
	}
}
