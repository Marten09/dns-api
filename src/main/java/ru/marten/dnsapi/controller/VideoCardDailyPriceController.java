package ru.marten.dnsapi.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import ru.marten.dnsapi.model.VideoCardDailyPrice;
import ru.marten.dnsapi.repository.VideoCardDailyPriceRepository;

import java.util.List;

@Controller
@RequiredArgsConstructor
public class VideoCardDailyPriceController {
    private final VideoCardDailyPriceRepository repository;

    @GetMapping("/")
    public String showPriceChart(Model model) {
        List<VideoCardDailyPrice> prices = repository.getLastFive();
        model.addAttribute("prices", prices);
        return "price_chart";
    }
}
