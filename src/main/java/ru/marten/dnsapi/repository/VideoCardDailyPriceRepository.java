package ru.marten.dnsapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import ru.marten.dnsapi.model.VideoCardDailyPrice;

import java.util.List;

@Repository
public interface VideoCardDailyPriceRepository extends JpaRepository<VideoCardDailyPrice, Long> {
    @Query("SELECT v FROM VideoCardDailyPrice v ORDER BY v.date desc LIMIT 5")
    List<VideoCardDailyPrice> getLastFive();
}
