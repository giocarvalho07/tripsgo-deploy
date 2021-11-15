package com.tripsgov2manager.repository;

import com.tripsgov2manager.model.Aluguel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AluguelRepository  extends JpaRepository< Aluguel, Long> {
}
