package ru.marten.dnsapi.service;

import lombok.AllArgsConstructor;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import ru.marten.dnsapi.repository.VideoCardRepository;
import ru.marten.dnsapi.util.VideoCardUtil;

@Service
@AllArgsConstructor
public class VideoCardService {
    private final VideoCardRepository repository;
    private final VideoCardUtil videoCardUtil;

    @Scheduled(cron = "0 0 0 * * *")
    private void save() {
        repository.saveAll(videoCardUtil.convertFromHtmlToList());
    }
}