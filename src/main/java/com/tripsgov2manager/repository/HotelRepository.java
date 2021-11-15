package com.tripsgov2manager.repository;

import com.tripsgov2manager.model.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HotelRepository  extends JpaRepository< Hotel, Long> {
}
