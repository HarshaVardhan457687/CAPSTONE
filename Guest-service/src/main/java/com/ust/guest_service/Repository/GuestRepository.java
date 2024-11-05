package com.ust.guest_service.Repository;

import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ust.guest_service.Model.Guest;

@Repository
public interface GuestRepository extends MongoRepository<Guest, String>{ 
	public Optional<Guest> findGuestByEventId(String eventId); 

}