package ru.marten.dnsapi.model;

import lombok.*;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "video_card_daily_average_price", uniqueConstraints = @UniqueConstraint(columnNames = "date"))
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class VideoCardDailyPrice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "average_price")
    private double averagePrice;

    @Column(name = "date")
    private LocalDate date;
}
