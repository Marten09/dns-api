package ru.marten.dnsapi.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.marten.dnsapi.model.VideoCardDailyPrice;
import ru.marten.dnsapi.repository.VideoCardDailyPriceRepository;
import ru.marten.dnsapi.util.VideoCardUtil;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class VideoCardDailyPriceService {
    private final VideoCardDailyPriceRepository repository;
    private final VideoCardUtil videoCardUtil;

    @Scheduled(cron = "0 0 0 * * *")
    public void save() {
        VideoCardDailyPrice videoCardDailyPrice = new VideoCardDailyPrice();
        videoCardDailyPrice.setAveragePrice(videoCardUtil.getAveragePrice());
        videoCardDailyPrice.setDate(LocalDate.now());
        repository.save(videoCardDailyPrice);
    }
}
