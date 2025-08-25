package com.sinse.restaurant.controller;

import com.sinse.restaurant.domain.Reservation;
import com.sinse.restaurant.model.reservation.ReservationService;
import lombok.RequiredArgsConstructor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/reservations")
@RequiredArgsConstructor
public class ReservationController {

    private final ReservationService reservationService;

    @PostMapping
    public ResponseEntity<Reservation> createReservation(@RequestParam Long userId,
                                                         @RequestParam Long storeId,
                                                         @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE_TIME) LocalDateTime dateTime) {
        return ResponseEntity.ok(reservationService.createReservation(userId, storeId, dateTime));
    }

    @GetMapping("/store/{storeId}")
    public List<Reservation> getReservations(@PathVariable Long storeId) {
        return reservationService.findReservationsByStore(storeId);
    }
}
