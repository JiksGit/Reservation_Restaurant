package com.sinse.restaurant.domain;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;
@Entity
@Table(
        name = "reservation",
        uniqueConstraints = {
                @UniqueConstraint(name = "reservation_unique", columnNames = {"store_id", "start_at", "end_at"})
        }
)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="user_id", nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="store_id", nullable = false)
    private Store store;

    private LocalDateTime startAt;
    private LocalDateTime endAt;
    private String status = "CONFIRMED";
    private LocalDateTime createdAt = LocalDateTime.now();
}
