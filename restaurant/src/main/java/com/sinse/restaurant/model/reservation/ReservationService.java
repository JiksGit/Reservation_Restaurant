package com.sinse.restaurant.model.reservation;

import com.sinse.restaurant.domain.Reservation;
import com.sinse.restaurant.domain.Store;
import com.sinse.restaurant.domain.User;
import com.sinse.restaurant.model.store.StoreRepository;
import com.sinse.restaurant.model.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ReservationService {

    private final ReservationRepository reservationRepository;
    private final StoreRepository storeRepository;
    private final UserRepository userRepository;

    @Transactional
    public Reservation createReservation(Long userId, Long storeId, LocalDateTime dateTime) {
        User user = userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));

        // 중복 예약 체크
        reservationRepository.findByStoreAndDateTime(store, dateTime)
                .ifPresent(r -> { throw new RuntimeException("이미 예약이 존재합니다"); });

        Reservation reservation = new Reservation();
        reservation.setUser(user);
        reservation.setStore(store);
        reservation.setDateTime(dateTime);

        return reservationRepository.save(reservation);
    }

    public List<Reservation> findReservationsByStore(Long storeId) {
        Store store = storeRepository.findById(storeId).orElseThrow(() -> new RuntimeException("Store not found"));
        return reservationRepository.findByStore(store);
    }
}
