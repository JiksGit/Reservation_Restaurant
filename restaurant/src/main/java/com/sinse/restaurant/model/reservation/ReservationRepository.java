package com.sinse.restaurant.model.reservation;

import com.sinse.restaurant.domain.Reservation;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface ReservationRepository extends JpaRepository<Reservation, Long> {
    List<Reservation> findByStoreIdAndStartAtBetween(Long storeId, LocalDateTime start, LocalDateTime end);
}