package com.example.Service.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Service.entites.Hotel;
import com.example.Service.ser.HotelService;

@RestController
@RequestMapping("hotel")
public class HotelController {

	@Autowired
	HotelService hotelService;
	
	@PreAuthorize("hasAuthority('Admin')")
	@PostMapping
	public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
		return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.CREATE(hotel));
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal')")
	@GetMapping("/{hotelId}")
	public ResponseEntity<Hotel> getSingleHotelById(@PathVariable String hotelId){
		Hotel hotel1 = hotelService.getById(hotelId);
	    return ResponseEntity.ok(hotel1);
	}
	
	@PreAuthorize("hasAuthority('SCOPE_internal') || hasAuthority('Admin')")
	@GetMapping
	public ResponseEntity<List<Hotel>> getAllHotel(){
		List<Hotel> hotel = hotelService.getAll();
	    return ResponseEntity.ok(hotel);
	}

	
}
