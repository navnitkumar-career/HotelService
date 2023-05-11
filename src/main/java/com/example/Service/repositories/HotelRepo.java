package com.example.Service.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Service.entites.Hotel;

public interface HotelRepo extends JpaRepository<Hotel, String> {

}
